package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

import client.ClientSocket;
import client.constants.ClientConstants;
import client.controller.ChangeColorController;
import client.controller.ExpressiveController;
import client.controller.MenuItemController;
import utility.FaceData;


/**
 * @SER516 Project3_Team03
 * @Version 1.0
 */

public class ClientUi extends JFrame{

	//JFrame frame;
//	ClientSocket socket;
//	
	
	private ColorSelectorButton interestButton;
	private ColorSelectorButton engagementButton;
	private ColorSelectorButton stressButton;
	private ColorSelectorButton relaxationButton;
	private ColorSelectorButton excitementButton;
	private ColorSelectorButton focusButton;
	
	

	JPanel facePanel; 


	/**
	 * Create the application.
	 */
	public ClientUi(JPanel expressiveView) {
		initialize(expressiveView);
		this.setBounds(new Rectangle(0, 0, 710, 432));
		this.getContentPane().setLayout(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JPanel expressiveView) {
		/*
		 * try { UIManager.setLookAndFeel(
		 * "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); } catch(Exception e) { }
		 */


		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 698, 402);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 22, 698, 380);
		panel.add(tabbedPane);


		
		
		tabbedPane.addTab("Expressive", null, expressiveView, null);

		

		final JPanel affectivePanel = new JPanel();
		tabbedPane.addTab("Affective", null, affectivePanel, null);
		affectivePanel.setLayout(null);

		final JPanel perfPanel = new JPanel();
		perfPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		perfPanel.setBounds(0, 30, 350, 311);
		affectivePanel.add(perfPanel);

		final JPanel colPanel = new JPanel();
		colPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		colPanel.setBounds(350, 30, 343, 311);
		
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.ipadx = 50;
		gridBagConstraints.ipady = 50;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(10, 10, 10, 10);
		
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		
		
		
		interestButton = new ColorSelectorButton(Color.WHITE,ClientConstants.INTEREST);
		new ChangeColorController(interestButton);
		colPanel.add(interestButton,gridBagConstraints);
			
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		
		engagementButton = new ColorSelectorButton(Color.black,ClientConstants.ENGAGEMENT);
		new ChangeColorController(engagementButton);

		
		colPanel.add(engagementButton,gridBagConstraints);
		
	
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		
		stressButton = new ColorSelectorButton(Color.black,ClientConstants.STRESS);

		
		new ChangeColorController(engagementButton);
		colPanel.add(stressButton,gridBagConstraints);
		
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		
		relaxationButton = new ColorSelectorButton(Color.black,ClientConstants.RELAXATION);

		new ChangeColorController(relaxationButton);
		
		colPanel.add(relaxationButton,gridBagConstraints);
		
		
		
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		
		excitementButton = new ColorSelectorButton(Color.black,ClientConstants.EXCITEMENT);

		new ChangeColorController(excitementButton);
		colPanel.add(excitementButton,gridBagConstraints);
			
		
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		
		focusButton = new ColorSelectorButton(Color.black,ClientConstants.FOCUS);

		new ChangeColorController(focusButton);
		colPanel.add(focusButton,gridBagConstraints);
		
		
		
		affectivePanel.add(colPanel);

		final JLabel perfLabel = new JLabel("    Performance Matrix");
		perfLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		perfLabel.setBounds(0, 0, 350, 32);
		affectivePanel.add(perfLabel);

		final JLabel colLabel = new JLabel("    Colors");
		colLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		colLabel.setBounds(350, 0, 343, 32);
		affectivePanel.add(colLabel);

		final JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 698, 22);
		panel.add(menuBar);

		final JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		final JMenu mntmApplication = new JMenu("Application");
		mnFile.add(mntmApplication);

		final JMenu mntmConnection = new JMenu("Connection");
		mnFile.add(mntmConnection);

		final JMenuItem serverConsole = new JMenuItem("Open Server");
		mntmApplication.add(serverConsole);

		JMenuItem serverConnect = new JMenuItem("Connect to Server");
		mntmConnection.add(serverConnect);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		mnFile.add(exitMenuItem);
		
		new MenuItemController(serverConnect, serverConsole, exitMenuItem);
	}

	public void setFaceData(FaceData faceData) {
		// @TODO information has been pushed from the server.
	}
}
