package client.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ExpressiveView extends JPanel{
	
	


	public ExpressiveView(JPanel facePanel, JPanel graphPanel,JPanel blinkGraph, JPanel rgtWinkGraph, JPanel lftWinkGraph, JPanel lookGraph, JPanel furrowGraph,
			JPanel raiseGraph, JPanel smileGraph, JPanel clenchGraph, JPanel lftSmirkGraph, JPanel rgtSmirkGraph, JPanel laughGraph){
		
		this.setLayout(null);
//		facePanel= new JPanel();
		facePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		facePanel.setBounds(0, 28, 326, 313);
		this.add(facePanel); 
		
		
		
		graphPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		graphPanel.setBounds(325, 28, 368, 313);
		graphPanel.setLayout(null);
		this.add(graphPanel);
		
		
		

//		final JPanel blinkGraph = new JPanel();
		blinkGraph.setBounds(90, 11, 260, 18);
		blinkGraph.setBackground(new Color(238, 238, 238));
		blinkGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(blinkGraph);

		JLabel blinkLabel = new JLabel("Blink\r\n");
		blinkLabel.setForeground(Color.WHITE);
		blinkLabel.setOpaque(true);
		blinkLabel.setBackground(Color.GRAY);
		blinkLabel.setHorizontalAlignment(SwingConstants.LEFT);
		blinkLabel.setBounds(10, 11, 68, 20);
		graphPanel.add(blinkLabel);

//		rgtWinkGraph = new JPanel();
		rgtWinkGraph.setBounds(90, 36, 260, 18);
		rgtWinkGraph.setBackground(new Color(238, 238, 238));
		rgtWinkGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(rgtWinkGraph);

		JLabel rgtWinkLabel = new JLabel("Right Wink");
		rgtWinkLabel.setBackground(Color.GRAY);
		rgtWinkLabel.setForeground(Color.WHITE);
		rgtWinkLabel.setOpaque(true);
		rgtWinkLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rgtWinkLabel.setBounds(10, 36, 68, 18);
		graphPanel.add(rgtWinkLabel);

//		lftWinkGraph = new JPanel();
		lftWinkGraph.setBounds(90, 65, 260, 18);
		lftWinkGraph.setBackground(new Color(238, 238, 238));
		lftWinkGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(lftWinkGraph);

		final JLabel lftWinkLabel = new JLabel("Left Wink");
		lftWinkLabel.setOpaque(true);
		lftWinkLabel.setForeground(Color.WHITE);
		lftWinkLabel.setBackground(Color.GRAY);
		lftWinkLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lftWinkLabel.setBounds(10, 65, 68, 20);
		graphPanel.add(lftWinkLabel);

//		lookGraph = new JPanel();
		lookGraph.setBounds(90, 90, 260, 18);
		lookGraph.setBackground(new Color(238, 238, 238));
		lookGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(lookGraph);

		final JLabel lookLabel = new JLabel("Look R/L");
		lookLabel.setOpaque(true);
		lookLabel.setForeground(Color.WHITE);
		lookLabel.setBackground(Color.GRAY);
		lookLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lookLabel.setBounds(10, 90, 68, 20);
		graphPanel.add(lookLabel);

//		furrowGraph = new JPanel();
		furrowGraph.setBounds(90, 115, 260, 18);
		furrowGraph.setBackground(new Color(238, 238, 238));
		furrowGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(furrowGraph);

		final JLabel furrowLabel = new JLabel("Furrow Brow\r\n");
		furrowLabel.setOpaque(true);
		furrowLabel.setForeground(Color.WHITE);
		furrowLabel.setBackground(Color.GRAY);
		furrowLabel.setHorizontalAlignment(SwingConstants.LEFT);
		furrowLabel.setBounds(10, 115, 68, 20);
		graphPanel.add(furrowLabel);

//		raiseGraph = new JPanel();
		raiseGraph.setBounds(90, 140, 260, 18);
		raiseGraph.setBackground(new Color(238, 238, 238));
		raiseGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(raiseGraph);

		final JLabel raiseLabel = new JLabel("Raise Brow");
		raiseLabel.setOpaque(true);
		raiseLabel.setForeground(Color.WHITE);
		raiseLabel.setBackground(Color.GRAY);
		raiseLabel.setBounds(10, 140, 68, 20);
		graphPanel.add(raiseLabel);

//		smileGraph = new JPanel();
		smileGraph.setBounds(90, 165, 260, 18);
		smileGraph.setBackground(new Color(238, 238, 238));
		smileGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(smileGraph);

		final JLabel smileLabel = new JLabel("Smile");
		smileLabel.setOpaque(true);
		smileLabel.setForeground(Color.WHITE);
		smileLabel.setBackground(Color.GRAY);
		smileLabel.setBounds(10, 165, 68, 20);
		graphPanel.add(smileLabel);

//		clenchGraph = new JPanel();
		clenchGraph.setBounds(90, 190, 260, 18);
		clenchGraph.setBackground(new Color(238, 238, 238));
		clenchGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(clenchGraph);

		final JLabel clenchLabel = new JLabel("Clench");
		clenchLabel.setOpaque(true);
		clenchLabel.setForeground(Color.WHITE);
		clenchLabel.setBackground(Color.GRAY);
		clenchLabel.setBounds(10, 190, 68, 20);
		graphPanel.add(clenchLabel);

//		lftSmirkGraph = new JPanel();
		lftSmirkGraph.setBounds(90, 215, 260, 18);
		lftSmirkGraph.setBackground(new Color(238, 238, 238));
		lftSmirkGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(lftSmirkGraph);

		final JLabel lftSmirkLabel = new JLabel("Left Smirk");
		lftSmirkLabel.setOpaque(true);
		lftSmirkLabel.setForeground(Color.WHITE);
		lftSmirkLabel.setBackground(Color.GRAY);
		lftSmirkLabel.setBounds(10, 215, 68, 20);
		graphPanel.add(lftSmirkLabel);

//		rgtSmirkGraph = new JPanel();
		rgtSmirkGraph.setBounds(90, 245, 260, 18);
		rgtSmirkGraph.setBackground(new Color(238, 238, 238));
		rgtSmirkGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(rgtSmirkGraph);

		final JLabel rgtSmirkLabel = new JLabel("Right Smirk");
		rgtSmirkLabel.setOpaque(true);
		rgtSmirkLabel.setForeground(Color.WHITE);
		rgtSmirkLabel.setBackground(Color.GRAY);
		rgtSmirkLabel.setBounds(10, 245, 68, 20);
		graphPanel.add(rgtSmirkLabel);

//		laughGraph = new JPanel();
		laughGraph.setBounds(90, 276, 260, 18);
		laughGraph.setBackground(new Color(238, 238, 238));
		laughGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(laughGraph);

		final JLabel laughLabel = new JLabel("Laugh");
		laughLabel.setOpaque(true);
		laughLabel.setForeground(Color.WHITE);
		laughLabel.setBackground(Color.GRAY);
		laughLabel.setBounds(10, 276, 68, 20);
		graphPanel.add(laughLabel);

		final JPanel blinkGraphPanel = new JPanel();
		blinkGraphPanel.setBounds(82, 11, 276, 20);
		graphPanel.add(blinkGraphPanel);

		final JPanel rgtWinkGraphPanel = new JPanel();
		rgtWinkGraphPanel.setBounds(82, 36, 276, 20);
		graphPanel.add(rgtWinkGraphPanel);

		final JPanel lftWinkGraphPanel = new JPanel();
		lftWinkGraphPanel.setBounds(82, 65, 276, 20);
		graphPanel.add(lftWinkGraphPanel);

		final JPanel lookGraphPanel = new JPanel();
		lookGraphPanel.setBounds(82, 90, 276, 20);
		graphPanel.add(lookGraphPanel);

		final JPanel furrowGraphPanel = new JPanel();
		furrowGraphPanel.setBounds(82, 115, 276, 20);
		graphPanel.add(furrowGraphPanel);

		final JPanel raiseGraphPanel = new JPanel();
		raiseGraphPanel.setBounds(82, 140, 276, 20);
		graphPanel.add(raiseGraphPanel);

		final JPanel smileGraphPanel = new JPanel();
		smileGraphPanel.setBounds(82, 165, 276, 20);
		graphPanel.add(smileGraphPanel);

		final JPanel clenchGraphPanel = new JPanel();
		clenchGraphPanel.setBounds(82, 190, 276, 20);
		graphPanel.add(clenchGraphPanel);

		final JPanel lftSmrGraphPanel = new JPanel();
		lftSmrGraphPanel.setBounds(82, 215, 276, 20);
		graphPanel.add(lftSmrGraphPanel);

		final JPanel rgtSmrGraphPanel = new JPanel();
		rgtSmrGraphPanel.setBounds(82, 245, 276, 20);
		graphPanel.add(rgtSmrGraphPanel);

		final JPanel laughGraphPanel = new JPanel();
		laughGraphPanel.setBounds(82, 276, 276, 18);
		graphPanel.add(laughGraphPanel);
		
		
		

	}

	

}
