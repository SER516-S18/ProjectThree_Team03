package server;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import org.json.JSONObject;

import utility.FaceAffectiveData;
import utility.FaceData;
import utility.FaceExpressionData;

public class EmoticonComposer extends JFrame {

			private JMenuBar menuBar;
			private JMenu mnNewMenu;
			private JMenuItem mntmAbout;
			JMenuItem mntmQuit;
			Thread inputThread;
			boolean running = false;
			double emoIntervalSelected = 1;
			Double timeElapsed = 0.0;
			InteractivePanel ipanel;
			DetectionPanel dpanel;

			
			public EmoticonComposer() {

				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception e) {
				}

				initialize();
			}

			/**
			 * Initialize the contents of the frame.
			 */
			private void initialize() {

				
				this.setBounds(100, 100, 531, 887);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.getContentPane().setLayout(null);
				
				try {
					JLabel imagePanel = new JLabel(new ImageIcon(ImageIO.read(new File("bg.jpg"))));
					imagePanel.setEnabled(true);
					this.setContentPane(imagePanel);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBounds(12, 30, 489, 175);
				this.getContentPane().add(tabbedPane);

				ipanel = new InteractivePanel();
				ipanel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) Color.BLACK));
				tabbedPane.addTab("INTERACTIVE", null, ipanel, null);
				ipanel.setLayout(null);

				
				JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane_1.setBounds(12, 243, 489, 552);
				this.getContentPane().add(tabbedPane_1);

				dpanel = new DetectionPanel();
				dpanel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) Color.BLACK));
				tabbedPane_1.addTab("DETECTION", null, dpanel, null);
				
				menuBar = new JMenuBar();
				this.setJMenuBar(menuBar);

				mnNewMenu = new JMenu("File");
				menuBar.add(mnNewMenu);
				

				mntmAbout = new JMenuItem("About");
				mnNewMenu.add(mntmAbout);
				

				mntmQuit = new JMenuItem("Quit");
				mnNewMenu.add(mntmQuit);
				
				new MenuController(mntmAbout, mntmQuit);
				
			}



			/*public FaceData getInputs() {
				FaceExpressionData faceExpressionData = new FaceExpressionData();
				FaceAffectiveData faceAffectiveData = new FaceAffectiveData();
				FaceData faceData = new FaceData();

				String upperFace = (String) comboUpperFace.getSelectedItem();
				Double upperFaceValue = Double.parseDouble((String) spinnerUpperFace.getValue());

				// System.out.println("UpperFace: " + upperFace);
				// System.out.println("Upperface value: "+upperFaceValue);

				switch (upperFace.toString()) {
				case "Raise Brow":
					faceExpressionData.setRaiseBrow(upperFaceValue);
					break;
				case "Furrow Brow":
					faceExpressionData.setFurrowBrow(upperFaceValue);
					break;
				}

				String lowerFace = (String) comboLowerFace.getSelectedItem();
				Double lowerFaceValue = Double.parseDouble((String) spinnerLowerFace.getValue());

				// System.out.println("LowerFace: " + lowerFace );
				// System.out.println("LowerFace Value: "+ lowerFaceValue);

				switch (lowerFace.toString()) {
				case "Smile":
					faceExpressionData.setSmile(lowerFaceValue);
					break;
				case "Clench":
					faceExpressionData.setClench(lowerFaceValue);
					break;
				case "Smirk Left":
					faceExpressionData.setSmirkLeft(lowerFaceValue);
					break;
				case "Smirk Right":
					faceExpressionData.setSmirkRight(lowerFaceValue);
					break;
				case "Laugh":
					faceExpressionData.setLaugh(lowerFaceValue);
					break;
				}

				boolean eyeActive = rdbtnActive.isSelected();

				// System.out.println("Eye Active: "+eyeActive);

				if (eyeActive) {
					String eye = (String) comboEye.getSelectedItem();
					// System.out.println("Eye :"+ eye);

					switch (eye) {
					case "Blink":
						faceExpressionData.setBlink(1.0);
						break;
					case "Wink Left":
						faceExpressionData.setWinkLeft(1.0);
						break;
					case "Wink Right":
						faceExpressionData.setWinkRight(1.0);
						break;
					case "Look Left":
						faceExpressionData.setLookLeft(1.0);
						break;
					case "Look Right":
						faceExpressionData.setLookRight(1.0);
						break;
					}
				}

				boolean eyeAutoReset = chckbxEyeAutoReset.isSelected();
				// System.out.println("Eye Auto Reset :"+ eyeAutoReset);

				if (eyeAutoReset) {
					faceExpressionData.setEyeReset(true);
				}

				String affective = (String) comboAffective.getSelectedItem();
				Double affectiveValue = Double.parseDouble((String) spinnerAffective.getValue());

				// System.out.println("Affective: "+affective);
				// System.out.println("Affective Value: "+affectiveValue);

				switch (affective) {
				case "Meditation":
					faceAffectiveData.setMeditation(affectiveValue);
					break;
				case "Engagement Boredom":
					faceAffectiveData.setEngagementBoredom(affectiveValue);
					break;
				case "Excitement ShortTerm":
					faceAffectiveData.setExcitementShortTerm(affectiveValue);
					break;
				case "Frustration":
					faceAffectiveData.setFrustation(affectiveValue);
					break;
				case "Excitement LongTerm":
					faceAffectiveData.setExcitementLongTerm(affectiveValue);
					break;
				}

				faceData.setFaceAffectiveData(faceAffectiveData);
				faceData.setFaceExpressionData(faceExpressionData);
				//System.out.println(faceData.toString());

				return faceData;
				// System.out.println(faceAffectiveData.toString());
				// System.out.println(faceExpressionData.toString());

			}*/
}