package server.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import server.ServerConsole;
import server.controller.DetectionController;
import utility.FaceAffectiveData;
import utility.FaceExpressionData;

public class DetectionPanel extends JPanel {
	

	private JTextField timeElapsedTextbox;
	private JSpinner spinnerEmoStateInterval, spinnerUpperFace, spinnerLowerFace, spinnerAffective;
	private JCheckBox  chckbxEyeAutoReset;
	private JTextArea txtAreaEmoLogs;
	private JButton btnSend, btnClearLogs;
	private JComboBox comboUpperFace, comboLowerFace, comboEye, comboAffective;
	private JRadioButton rdbtnActive;
	public FaceExpressionData faceExpressionData;
	public FaceAffectiveData faceAffectiveData;
	public JLabel lblEmoState;
	public DetectionPanel(){
		SpringLayout springpanel = new SpringLayout();
		this.setLayout(springpanel);
		
		faceAffectiveData= new FaceAffectiveData();
		faceExpressionData = new FaceExpressionData();
		
		lblEmoState = new JLabel("EMO STATE");
		springpanel.putConstraint(SpringLayout.NORTH, lblEmoState, 13, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, lblEmoState, 12, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, lblEmoState, 88, SpringLayout.WEST, this);
		

		JLabel lblTime = new JLabel("TIME: ");
		springpanel.putConstraint(SpringLayout.NORTH, lblTime, 47, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, lblTime, 22, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, lblTime, 70, SpringLayout.WEST, this);
		this.add(lblTime);

		timeElapsedTextbox = new JTextField();
		timeElapsedTextbox.setEditable(false);
		springpanel.putConstraint(SpringLayout.NORTH, timeElapsedTextbox, 44, SpringLayout.NORTH,
				this);
		springpanel.putConstraint(SpringLayout.WEST, timeElapsedTextbox, 74, SpringLayout.WEST, this);
		this.add(timeElapsedTextbox);
		timeElapsedTextbox.setColumns(10);

		JLabel lblSeconds = new JLabel("Seconds");
		springpanel.putConstraint(SpringLayout.NORTH, lblSeconds, 47, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, lblSeconds, 202, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, lblSeconds, 258, SpringLayout.WEST, this);
		this.add(lblSeconds);

		JLabel lblUpperFace = new JLabel("Upperface:");
		springpanel.putConstraint(SpringLayout.WEST, lblUpperFace, 0, SpringLayout.WEST, lblEmoState);
		springpanel.putConstraint(SpringLayout.EAST, lblUpperFace, 88, SpringLayout.WEST, this);
		this.add(lblUpperFace);

		comboUpperFace = new JComboBox();
		springpanel.putConstraint(SpringLayout.SOUTH, lblUpperFace, -6, SpringLayout.NORTH, comboUpperFace);
		springpanel.putConstraint(SpringLayout.NORTH, comboUpperFace, 144, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, comboUpperFace, 12, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, comboUpperFace, 111, SpringLayout.WEST, this);
		comboUpperFace.setModel(new DefaultComboBoxModel(new String[] { "Raise Brow", "Furrow Brow" }));
		this.add(comboUpperFace);

		spinnerUpperFace = new JSpinner();
		springpanel.putConstraint(SpringLayout.NORTH, spinnerUpperFace, 144, SpringLayout.NORTH,this);
		springpanel.putConstraint(SpringLayout.WEST, spinnerUpperFace, 125, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, spinnerUpperFace, 190, SpringLayout.WEST, this);
		spinnerUpperFace.setModel(new SpinnerListModel(
				new String[] { "0", "0.10", "0.20", "0.30", "0.40", "0.50", "0.60", "0.70", "0.80", "0.90", "1" }));
		this.add(spinnerUpperFace);

		JLabel lblLowerface = new JLabel("Lowerface:");
		springpanel.putConstraint(SpringLayout.NORTH, lblLowerface, 0, SpringLayout.NORTH, lblUpperFace);
		springpanel.putConstraint(SpringLayout.WEST, lblLowerface, 276, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, lblLowerface, -126, SpringLayout.EAST, this);
		this.add(lblLowerface);

		comboLowerFace = new JComboBox();
		springpanel.putConstraint(SpringLayout.NORTH, comboLowerFace, 144, SpringLayout.NORTH, this);
		comboLowerFace.setModel(
				new DefaultComboBoxModel(new String[] { "Smile", "Clench", "Smirk Left", "Smirk Right", "Laugh" }));
		this.add(comboLowerFace);

		spinnerLowerFace = new JSpinner();
		springpanel.putConstraint(SpringLayout.EAST, comboLowerFace, -10, SpringLayout.WEST, spinnerLowerFace);
		springpanel.putConstraint(SpringLayout.NORTH, spinnerLowerFace, 144, SpringLayout.NORTH,
				this);
		springpanel.putConstraint(SpringLayout.WEST, spinnerLowerFace, 402, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, spinnerLowerFace, 458, SpringLayout.WEST, this);
		spinnerLowerFace.setModel(new SpinnerListModel(
				new String[] { "0", "0.10", "0.20", "0.30", "0.40", "0.50", "0.60", "0.70", "0.80", "0.90", "1" }));
		this.add(spinnerLowerFace);

		JLabel lblEye = new JLabel("Eye:");
		springpanel.putConstraint(SpringLayout.WEST, lblEye, 0, SpringLayout.WEST, lblEmoState);
		springpanel.putConstraint(SpringLayout.EAST, lblEye, -2, SpringLayout.EAST, lblTime);
		this.add(lblEye);

		comboEye = new JComboBox();
		springpanel.putConstraint(SpringLayout.SOUTH, lblEye, -6, SpringLayout.NORTH, comboEye);
		springpanel.putConstraint(SpringLayout.NORTH, comboEye, 238, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, comboEye, 0, SpringLayout.WEST, lblEmoState);
		springpanel.putConstraint(SpringLayout.EAST, comboEye, 0, SpringLayout.EAST, comboUpperFace);
		comboEye.setModel(new DefaultComboBoxModel(
				new String[] { "Blink", "Wink Left", "Wink Right", "Look Left", "Look Right" }));
		this.add(comboEye);

		rdbtnActive = new JRadioButton("Active");
		springpanel.putConstraint(SpringLayout.NORTH, rdbtnActive, -1, SpringLayout.NORTH, comboEye);
		springpanel.putConstraint(SpringLayout.WEST, rdbtnActive, 120, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, rdbtnActive, 0, SpringLayout.EAST, timeElapsedTextbox);
		this.add(rdbtnActive);

		chckbxEyeAutoReset = new JCheckBox("Auto Reset");
		springpanel.putConstraint(SpringLayout.NORTH, chckbxEyeAutoReset, 6, SpringLayout.SOUTH, comboEye);
		springpanel.putConstraint(SpringLayout.WEST, chckbxEyeAutoReset, 0, SpringLayout.WEST, lblEmoState);
		springpanel.putConstraint(SpringLayout.EAST, chckbxEyeAutoReset, -359, SpringLayout.EAST,this);
		this.add(chckbxEyeAutoReset);

		JLabel lblEmoengineLogs = new JLabel("EmoEngine Logs");
		springpanel.putConstraint(SpringLayout.NORTH, lblEmoengineLogs, 316, SpringLayout.NORTH,
				this);
		springpanel.putConstraint(SpringLayout.WEST, lblEmoengineLogs, 25, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, lblEmoengineLogs, 124, SpringLayout.WEST, this);
		this.add(lblEmoengineLogs);

		txtAreaEmoLogs = new JTextArea();
		txtAreaEmoLogs.setEditable(true);
		springpanel.putConstraint(SpringLayout.NORTH, txtAreaEmoLogs, 345, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, txtAreaEmoLogs, 22, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.SOUTH, txtAreaEmoLogs, 474, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.EAST, txtAreaEmoLogs, 458, SpringLayout.WEST, this);
		txtAreaEmoLogs.setRows(5);
		
		ServerConsole sc = ServerConsole.getInstance();
		sc.setJtextArea(txtAreaEmoLogs);
		this.add(txtAreaEmoLogs);

		btnClearLogs = new JButton("Clear Logs");
		springpanel.putConstraint(SpringLayout.NORTH, btnClearLogs, 487, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, btnClearLogs, 185, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, btnClearLogs, 282, SpringLayout.WEST, this);
		this.add(btnClearLogs);
	

		JLabel lblAffective = new JLabel("Affective:");
		springpanel.putConstraint(SpringLayout.NORTH, lblAffective, 0, SpringLayout.NORTH, lblEye);
		springpanel.putConstraint(SpringLayout.WEST, lblAffective, 0, SpringLayout.WEST, lblLowerface);
		this.add(lblAffective);

		comboAffective = new JComboBox();
		springpanel.putConstraint(SpringLayout.WEST, comboLowerFace, 0, SpringLayout.WEST, comboAffective);
		springpanel.putConstraint(SpringLayout.WEST, comboAffective, 47, SpringLayout.EAST, rdbtnActive);
		springpanel.putConstraint(SpringLayout.NORTH, comboAffective, 238, SpringLayout.NORTH, this);
		comboAffective.setModel(new DefaultComboBoxModel(new String[] { "Meditation", "Engagement Boredom",
				"Excitement ShortTerm", "Frustration", "Excitement LongTerm" }));
		this.add(comboAffective);
		
		
		
		spinnerAffective = new JSpinner();
		springpanel.putConstraint(SpringLayout.EAST, comboAffective, -10, SpringLayout.WEST, spinnerAffective);
		springpanel.putConstraint(SpringLayout.NORTH, spinnerAffective, 0, SpringLayout.NORTH, rdbtnActive);
		springpanel.putConstraint(SpringLayout.WEST, spinnerAffective, 0, SpringLayout.WEST, spinnerLowerFace);
		springpanel.putConstraint(SpringLayout.EAST, spinnerAffective, 0, SpringLayout.EAST, spinnerLowerFace);
		spinnerAffective.setModel(new SpinnerListModel(
		new String[] {"0","0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0" }));
		this.add(spinnerAffective);
		
		addComponent();
		
		new DetectionController(spinnerUpperFace, spinnerLowerFace, spinnerAffective, comboUpperFace, comboLowerFace,
				comboAffective, comboEye, chckbxEyeAutoReset, rdbtnActive,faceAffectiveData,faceExpressionData);
		
	}
	
	public void addComponent(){
		add(lblEmoState);
		
	}
	
}
