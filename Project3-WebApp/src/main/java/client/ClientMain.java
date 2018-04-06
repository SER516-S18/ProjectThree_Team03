package client;

import java.awt.EventQueue;

import client.controller.ClientController;


public class ClientMain {
	private static ClientController window;
	

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ClientController();

//					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
