package client;

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
//import javax.swing.UIManager;
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

import client.constants.ClientConstants;
import client.controller.ChangeColorController;
import client.controller.ExpressiveController;
import client.view.ColorSelectorButton;
import client.view.DisplayGraph;
import client.view.ExpressiveView;
import client.view.FacePaint;
import client.view.ColorSelectorButton.ColorChangedListener;




/**
 * @SER516 Project3_Team03
 * @Version 1.0
 */

public class ClientUi extends JFrame{

	//JFrame frame;
	ClientSocket socket;
	
	
	private ColorSelectorButton interestButton;
	private ColorSelectorButton engagementButton;
	private ColorSelectorButton stressButton;
	private ColorSelectorButton relaxationButton;
	private ColorSelectorButton excitementButton;
	private ColorSelectorButton focusButton;
	ExpressiveController expressiveController;

	JPanel facePanel; 


	/**
	 * Create the application.
	 */
	public ClientUi() {
		initialize();
		this.setBounds(new Rectangle(0, 0, 710, 432));
		this.getContentPane().setLayout(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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

//		final JPanel expressivePanel = new JPanel();
//		ExpressiveView expressivePanel = new ExpressiveView();
		
//		expressivePanel.setLayout(null);

//		facePanel = new JPanel();

//		expressivePanel = new ExpressiveView(facePanel);
		expressiveController=new ExpressiveController();
		
		tabbedPane.addTab("Expressive", null, expressiveController.expressiveView, null);

		

//		JPanel graphPanel = new JPanel();
//		graphPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		graphPanel.setBounds(325, 28, 368, 313);
//		expressivePanel.add(graphPanel);
//		graphPanel.setLayout(null);


//		final JLabel faceLabel = new JLabel("    Face Expression");
//		faceLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
//		faceLabel.setBounds(0, 3, 336, 26);
//		expressiveController.expressiveView.add(faceLabel);

//		final JLabel graphLabel = new JLabel("    Graph Charts");
//		graphLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
//		graphLabel.setBounds(336, 0, 357, 29);
//		expressiveController.expressiveView.add(graphLabel);

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
		
		
		
//		
//		gridBagConstraints.insets = new Insets(10, 5, 10, 5);
//		gridBagConstraints.gridx = 1;
//		gridBagConstraints.gridy = 3;
//		displaylengthLabel = new JLabel(ClientConstants.DISPLAY_LENGTH);
//		displaylengthLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
//		displaylengthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//		displaylengthLabel.setFont(FONT);
//		mainPanel.add(displaylengthLabel, gridBagConstraints);
//
//		gridBagConstraints.gridx = 2;
//		gridBagConstraints.gridy = 3;
//		displayLengthField = new NumberTextField("" + performanceMetricModel.getDisplayLength());
//		displayLengthField.setBackground(LIGHTPINK);
//		displayLengthField.setHorizontalAlignment(SwingConstants.CENTER);
//		displayLengthField.setFont(FONT);
//		displayLengthField.setBorder(new LineBorder(BLACK));
//		displayLengthField.setColumns(10);
//		mainPanel.add(displayLengthField, gridBagConstraints);
//		
		
		
		
		
		
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

		final JMenuItem serverConsole = new JMenuItem("Server");
		mntmApplication.add(serverConsole);

//		Thread t = new Thread(new Runnable() {
//
//			public void run() {
//				while (true) {
//
//					facePanel.add(f, BorderLayout.CENTER);
//					facePanel.repaint();
//					List<Double> al = new ArrayList<Double>();
//					Random rand = new Random();
//					double pick;
//					for (int j = 0; j < 1; j++) {
//						pick = rand.nextDouble();
//						al.add(pick);
//					}
//					g.addValues(al);
//					g1.addValues(al);
//					g2.addValues(al);
//					g3.addValues(al);
//					g4.addValues(al);
//					g5.addValues(al);
//					g6.addValues(al);
//					g7.addValues(al);
//					g8.addValues(al);
//					g9.addValues(al);
//					g10.addValues(al);
//					g11.addValues(al);
//					// System.out.println(al);
//
//					blinkGraph.add(g, BorderLayout.CENTER);
//					blinkGraph.repaint();
//					rgtWinkGraph.add(g1, BorderLayout.CENTER);
//					rgtWinkGraph.repaint();
//					lftWinkGraph.add(g2, BorderLayout.CENTER);
//					lftWinkGraph.repaint();
//					rgtWinkGraph.add(g3, BorderLayout.CENTER);
//					rgtWinkGraph.repaint();
//					lookGraph.add(g4, BorderLayout.CENTER);
//					lookGraph.repaint();
//					furrowGraph.add(g5, BorderLayout.CENTER);
//					furrowGraph.repaint();
//					raiseGraph.add(g6, BorderLayout.CENTER);
//					raiseGraph.repaint();
//					smileGraph.add(g7, BorderLayout.CENTER);
//					smileGraph.repaint();
//					clenchGraph.add(g8, BorderLayout.CENTER);
//					clenchGraph.repaint();
//					lftSmirkGraph.add(g9, BorderLayout.CENTER);
//					lftSmirkGraph.repaint();
//					rgtSmirkGraph.add(g10, BorderLayout.CENTER);
//					rgtSmirkGraph.repaint();
//					laughGraph.add(g11, BorderLayout.CENTER);
//					laughGraph.repaint();
//
//					// System.out.println(al);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//		});
//		t.start();

		JMenuItem serverConnect = new JMenuItem("Connect to Server");
		serverConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField host = new JTextField();
				JTextField port = new JTextField();

				Object[] fields = { "Host Name", host, "Port", port };
				int input = JOptionPane.showConfirmDialog(null, fields, "Connect To Server",
						JOptionPane.OK_CANCEL_OPTION);
				if (input == JOptionPane.OK_OPTION) {
					String dest = "ws://" + host.getText();
					socket = ClientSocket.getInstance();
					WebSocketContainer container = ContainerProvider.getWebSocketContainer();
					try {
						container.connectToServer(socket, new URI(dest));
					} catch (DeploymentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, socket.isConnected() ? "Connected to " + host.getText()
							: "Not connected to " + host.getText());
				}
			}
		});
		mntmConnection.add(serverConnect);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(exitMenuItem);
	}
}
