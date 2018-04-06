package client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.service.FaceClient;
import server.ServerMainHandler;

public class MenuItemController {

	public MenuItemController(JMenuItem serverConnect, JMenuItem serverConsole, JMenuItem exit) {

		serverConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField host = new JTextField();
				JTextField port = new JTextField();

				Object[] fields = { "Host Name", host, "Port", port };
				int input = JOptionPane.showConfirmDialog(null, fields, "Connect To Server",
						JOptionPane.OK_CANCEL_OPTION);
				if (input == JOptionPane.OK_OPTION) {
					try {
						FaceClient.connect(host.getText(), port.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, FaceClient.isConnected() ? "Connected to " + host.getText()
							: "Not connected to " + host.getText());
				}
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		serverConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServerMainHandler.startServerGUI();
			}
		});
	}

}
