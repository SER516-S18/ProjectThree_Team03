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
		

	}
	
	public static void main(String[] args) {
		ServerMainHandler sm = new ServerMainHandler();
		
	}

}
