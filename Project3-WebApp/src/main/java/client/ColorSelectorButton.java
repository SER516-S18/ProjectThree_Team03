package client;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class ColorSelectorButton extends JButton {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color current;
	private String name;

    public ColorSelectorButton(Color c, String name) {
        setSelectedColor(c); 
        setName(name);
        this.setText(name);
        addActionListener(new ActionListener() {
   
            public void actionPerformed(ActionEvent arg0) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", current);
                setSelectedColor(newColor);
            }
        });
    }

    public Color getSelectedColor() {
        return current;
    }

    public void setSelectedColor(Color newColor) {
        setSelectedColor(newColor, true);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String newName) {
    		name=newName;
    		
    }

    public void setSelectedColor(Color newColor, boolean notify) {

        if (newColor == null) return;

        current = newColor;
        setIcon(createIcon(current,10, 10));
        repaint();

        if (notify) {
            // Notify everybody that may be interested.
            for (ColorChangedListener l : listeners) {
                l.colorChanged(newColor);
            }
        }
    }

    public static interface ColorChangedListener {
        public void colorChanged(Color newColor);
    }

    private List<ColorChangedListener> listeners = new ArrayList<ColorChangedListener>();

    public void addColorChangedListener(ColorChangedListener toAdd) {
        listeners.add(toAdd);
    }

    public static  ImageIcon createIcon(Color main, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(main);
        graphics.fillRect(0, 0, width, height);
        graphics.setXORMode(Color.DARK_GRAY);
        graphics.drawRect(0, 0, width-1, height-1);
        image.flush();
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }
}
