package server;

import server.service.FaceServer;
import server.view.EmoticonComposer;

/**
 * Main class that is invoked when the server has to be started.
 * @SER516 Project3_Team03
 * @Version 1.0
 */
public class ServerMainHandler {

	EmoticonComposer emoticon;

	public ServerMainHandler() {
		FaceServer.start(8000);
		emoticon = new EmoticonComposer();
		emoticon.setVisible(true);
		emoticon.setResizable(false);
		ServerConsole sc = ServerConsole.getInstance();
		sc.print("Server Started");
	}
}
