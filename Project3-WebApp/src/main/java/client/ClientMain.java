package client;

import java.awt.EventQueue;

public class ClientMain {
	private static ClientUi window;
	

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ClientUi();

					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
