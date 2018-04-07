package client.controller;

import client.view.ClientUi;
/**
 * Main Controller that invokes the client UI
 * @SER516 Project3_Team03
 * @version 1.0
 */
public class ClientController {
	ClientUi clientui;
	ExpressiveController expressiveController;

	public ClientController() {
		expressiveController = new ExpressiveController();
		clientui = new ClientUi(expressiveController);
		clientui.setVisible(true);

	}
}
