/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import client.constants.ClientConstants;
import client.controller.ChangeColorController;

/**
 *
 * @author srajangupta
 */
public class AffectiveView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ColorSelectorButton interestButton;
	private ColorSelectorButton engagementButton;
	private ColorSelectorButton stressButton;
	private ColorSelectorButton relaxationButton;
	private ColorSelectorButton excitementButton;
	private ColorSelectorButton focusButton;

	public AffectiveView(JPanel leftPanel, JPanel affectiveGraph, JPanel colPanel) {

		this.setLayout(null);
		leftPanel.setBounds(0, 28, 326, 313);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		leftPanel.setLayout(null);
		this.add(leftPanel);

		affectiveGraph.setBounds(0, 0, 320, 300);
		affectiveGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		affectiveGraph.setBackground(new Color(238, 238, 238));
		leftPanel.add(affectiveGraph);


//		perfPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		perfPanel.setBounds(325, 28, 368, 313);
//		perfPanel.setLayout(null);
		//this.add(perfPanel);

//		final JPanel colPanel = new JPanel();
		colPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		colPanel.setBounds(350, 30, 343, 311);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.ipadx = 50;
		gridBagConstraints.ipady = 50;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(10, 10, 10, 10);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;

		interestButton = new ColorSelectorButton(Color.WHITE, ClientConstants.INTEREST);
		new ChangeColorController(interestButton);
		colPanel.add(interestButton, gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;

		engagementButton = new ColorSelectorButton(Color.black, ClientConstants.ENGAGEMENT);
		new ChangeColorController(engagementButton);

		colPanel.add(engagementButton, gridBagConstraints);

		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;

		stressButton = new ColorSelectorButton(Color.black, ClientConstants.STRESS);

		new ChangeColorController(engagementButton);
		colPanel.add(stressButton, gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;

		relaxationButton = new ColorSelectorButton(Color.black, ClientConstants.RELAXATION);

		new ChangeColorController(relaxationButton);

		colPanel.add(relaxationButton, gridBagConstraints);

		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;

		excitementButton = new ColorSelectorButton(Color.black, ClientConstants.EXCITEMENT);

		new ChangeColorController(excitementButton);
		colPanel.add(excitementButton, gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;

		focusButton = new ColorSelectorButton(Color.black, ClientConstants.FOCUS);

		new ChangeColorController(focusButton);
		colPanel.add(focusButton, gridBagConstraints);

		this.add(colPanel);

		final JLabel perfLabel = new JLabel("    Performance Matrix");
		perfLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		perfLabel.setBounds(0, 0, 350, 32);
		this.add(perfLabel);

		final JLabel colLabel = new JLabel("    Colors");
		colLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		colLabel.setBounds(350, 0, 343, 32);
		this.add(colLabel);

	}

}
