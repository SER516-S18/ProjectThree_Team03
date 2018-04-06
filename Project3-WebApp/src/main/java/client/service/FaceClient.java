package client.service;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import client.view.ClientUi;
import utility.FaceData;

@ClientEndpoint
public class FaceClient {

	private static Gson gson = null;
	private static ClientUi observer = null;

	public static void create(String host, int port, ClientUi observer) throws Exception {
		FaceClient.gson = new GsonBuilder().create();
		FaceClient.observer = observer;
		ClientManager client = ClientManager.createClient();
		client.connectToServer(FaceClient.class, new URI("ws://" + host + ":" + String.valueOf(port) + "/faceServer"));
	}

	@OnOpen
	public void onOpen(Session session) throws Exception {
		System.out.println("Connected ... " + session.getId());
	}

	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		System.out.println("Received ...." + message);
		FaceData faceData = gson.fromJson(message, FaceData.class);
		observer.setFaceData(faceData);
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println(String.format("Session %s close because of %s", session.getId(), closeReason));
	}

}