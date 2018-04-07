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
	AffectiveController affectiveController;

	public ClientController() {
		expressiveController = new ExpressiveController();
		affectiveController = new AffectiveController();
		clientui = new ClientUi(expressiveController, affectiveController);
		clientui.setVisible(true);

	}
}
