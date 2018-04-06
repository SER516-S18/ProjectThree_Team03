package server.service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.glassfish.tyrus.server.Server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import utility.FaceData;

@ServerEndpoint(value = "/faceData")
public class FaceServer {

	private static Gson gson = null;
	private static Session session = null;
	private static Server server = null;

	public static void start(int port) {
		if (FaceServer.gson == null) {
			FaceServer.gson = new GsonBuilder().create();
		}
		FaceServer.server = new Server("localhost", port, "/", null, FaceServer.class);
		try {
			System.out.println("Server Started");
			FaceServer.server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void stop() {
		try {
			FaceServer.server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void put(FaceData faceData) {
		if (FaceServer.session == null) {
			System.out.println("No session present.");
			return;
		}
		try {
			String message = FaceServer.gson.toJson(faceData, FaceData.class);
			FaceServer.session.getBasicRemote().sendText(message);
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnOpen
	public void onOpen(Session session) {
		if (FaceServer.session != null) {
			System.out.println(session.getId() + " has opened a connection, but a connection is already open.");
			try {
				session.getBasicRemote().sendText("Only one client is allowed at a time");
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		FaceServer.session = session;
		System.out.println(session.getId() + " has opened a connection");
	}

	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		System.out.println(message);
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("Session " + session.getId() + " has ended");
		if (session == FaceServer.session) {
			FaceServer.session = null;
		}
	}
}