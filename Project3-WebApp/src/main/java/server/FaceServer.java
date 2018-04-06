package server;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.glassfish.tyrus.server.Server;

import utility.FaceData;
 
/** 
 * @ServerEndpoint gives the relative name for the end point
 * This will be accessed via ws://localhost:8080/EchoChamber/echo
 * Where "localhost" is the address of the host,
 * "EchoChamber" is the name of the package
 * and "echo" is the address to access this class from the server
 */
@ServerEndpoint(value = "/faceData") 
public class FaceServer {

	private static Gson gson = null;
    private static Session session = null;
    private static Server server = null;

    public static void main(String[] args) {
        // Server server = new Server("localhost", 8025, "/", null, FaceServer.class);
        FaceServer.start(8025);
        try {
            server.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // System.out.print("Please press a key to stop the server.");
            String line = reader.readLine();
            while (!"exit".equals(line)) {
                FaceServer.put(new FaceData());
                line = reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }

    public static void start(int port) {
        if (FaceServer.gson == null) {
            FaceServer.gson = new GsonBuilder().create();
        }
        FaceServer.server = new Server("localhost", port, "/", null, FaceServer.class);
        try {
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

    @OnOpen
    public void onOpen(Session session) {
        if (FaceServer.session != null) {
            System.out.println(session.getId() +
                " has opened a connection, but a connection is already open."); 
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
    public void onClose(Session session){
        System.out.println("Session " + session.getId() + " has ended");
        if (session == FaceServer.session) {
            FaceServer.session = null;    
        }
    }

    public static void put(FaceData faceData) {
        try {
            String message = FaceServer.gson.toJson(faceData, FaceData.class);
            FaceServer.session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}