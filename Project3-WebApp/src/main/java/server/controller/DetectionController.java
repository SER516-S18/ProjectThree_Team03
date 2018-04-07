package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import utility.FaceAffectiveData;
import utility.FaceData;
import utility.FaceExpressionData;

public class DetectionController {

	public JSpinner spinnerEmoStateInterval, spinnerUpperFace, spinnerLowerFace, spinnerAffective;
	public JCheckBox chckbxEyeAutoReset;
	public JComboBox comboUpperFace, comboLowerFace, comboEye, comboAffective;
	public JRadioButton radioEyeActive;
	public FaceAffectiveData faceAffectiveData;
	public FaceExpressionData faceExpressionData;

	public DetectionController(final JSpinner spinnerUpperFace, final JSpinner spinnerLowerFace,
			final JSpinner spinnerAffective, final JComboBox comboUpperFace, final JComboBox comboLowerFace,
			final JComboBox comboAffective, final JComboBox comboEye, final JCheckBox checkEyeBox,
			final JRadioButton radioEyeActive, FaceAffectiveData faceAffectiveData,
			FaceExpressionData faceExpressionData) {

		this.faceAffectiveData = faceAffectiveData;
		this.faceExpressionData = faceExpressionData;
		this.spinnerAffective = spinnerAffective;
		this.spinnerLowerFace = spinnerLowerFace;
		this.spinnerUpperFace = spinnerUpperFace;
		this.comboUpperFace = comboUpperFace;
		this.comboLowerFace = comboLowerFace;
		this.comboAffective = comboAffective;
		this.comboEye = comboEye;
		this.radioEyeActive = radioEyeActive;
		this.chckbxEyeAutoReset = checkEyeBox;

		comboUpperFace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(comboUpperFace.getSelectedItem());
				updateExpressionData();
			}
		});

		comboLowerFace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(comboLowerFace.getSelectedItem());
				updateExpressionData();
			}
		});

		comboAffective.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(comboAffective.getSelectedItem());
				updateAffectiveData();
			}
		});

		comboEye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(comboEye.getSelectedItem());
				updateExpressionData();
			}
		});

		chckbxEyeAutoReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(chckbxEyeAutoReset.isSelected());
				updateExpressionData();
			}
		});

		radioEyeActive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(radioEyeActive.isSelected());
				updateExpressionData();
			}
		});

		spinnerUpperFace.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// System.out.println(spinnerUpperFace.getValue());
				updateExpressionData();
			}
		});

		spinnerLowerFace.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// System.out.println(spinnerLowerFace.getValue());
				updateExpressionData();
			}
		});

		spinnerAffective.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// System.out.println(spinnerAffective.getValue());
				updateAffectiveData();
			}
		});

	}

	public void updateExpressionData() {

		faceExpressionData.reset();
		String upperFace = (String) comboUpperFace.getSelectedItem();
		Double upperFaceValue = Double.parseDouble((String) spinnerUpperFace.getValue());

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

		boolean eyeActive = radioEyeActive.isSelected();

		if (eyeActive) {
			String eye = (String) comboEye.getSelectedItem();

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

		if (eyeAutoReset) {
			faceExpressionData.setEyeReset(true);
		}
		// System.out.println(faceExpressionData.toString());
		//createFaceDataInstance();
	}

	public void updateAffectiveData() {

		faceAffectiveData.reset();

		String affective = (String) comboAffective.getSelectedItem();
		Double affectiveValue = Double.parseDouble((String) spinnerAffective.getValue());

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
		// System.out.println(faceAffectiveData.toString());
		//createFaceDataInstance();
	}

	public FaceData createFaceDataInstance() {
		FaceData faceData = new FaceData();
		faceData.setFaceAffectiveData(faceAffectiveData);
		faceData.setFaceExpressionData(faceExpressionData);
		// JSONObject faceDataJson = new JSONObject(faceData);
		// String jsonResponse = faceDataJson.toString();
		// System.out.println(jsonResponse);
		return faceData;
	}
}
