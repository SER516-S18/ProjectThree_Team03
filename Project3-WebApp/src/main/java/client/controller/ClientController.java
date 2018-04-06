package client.controller;

import client.view.ClientUi;

public class ClientController {
	ClientUi clientui;
	ExpressiveController expressiveController;

	public ClientController() {
		expressiveController = new ExpressiveController();
		clientui = new ClientUi(expressiveController);
		clientui.setVisible(true);

	}
}
