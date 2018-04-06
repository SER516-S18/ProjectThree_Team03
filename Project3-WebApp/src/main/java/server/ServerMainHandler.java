package server;

import org.json.JSONObject;

import server.view.EmoticonComposer;
import utility.FaceData;

public class ServerMainHandler {

	EmoticonComposer emoticon;
	public ServerMainHandler(){
		
		emoticon = new EmoticonComposer();
		emoticon.setVisible(true);
		emoticon.setResizable(false);
		FaceData faceData = new FaceData();
		faceData.setFaceAffectiveData(emoticon.dpanel.faceAffectiveData);
		faceData.setFaceExpressionData(emoticon.dpanel.faceExpressionData);
	
	}
	
	public static void main(String[] args) {
		ServerMainHandler sm = new ServerMainHandler();
	/*	FaceServer server = new FaceServer();
		
		server.start(1000);
		server.put(faceData);*/
	}

}
