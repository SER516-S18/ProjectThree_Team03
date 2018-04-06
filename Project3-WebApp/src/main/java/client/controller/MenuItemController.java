package client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

import client.ClientSocket;

public class MenuItemController {
	ClientSocket socket;
	
	public MenuItemController(JMenuItem serverConnect, JMenuItem serverConsole, JMenuItem exit) {
		
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
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
