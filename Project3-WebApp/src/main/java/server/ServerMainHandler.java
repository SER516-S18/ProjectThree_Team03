package server;

import server.service.FaceServer;
import server.view.EmoticonComposer;
import utility.FaceData;

public class ServerMainHandler {

	EmoticonComposer emoticon;

	public ServerMainHandler() {

		emoticon = new EmoticonComposer();
		emoticon.setVisible(true);
		emoticon.setResizable(false);
		FaceData faceData = new FaceData();
		faceData.setFaceAffectiveData(emoticon.dpanel.faceAffectiveData);
		faceData.setFaceExpressionData(emoticon.dpanel.faceExpressionData);

	}

	public static void startServerGUI() {
		System.out.println("entered server gui");
		ServerMainHandler sm = new ServerMainHandler();
		FaceServer.start(8000);
	}

}
