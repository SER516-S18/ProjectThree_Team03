package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;
 
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
 
import org.glassfish.tyrus.client.ClientManager;

import utility.FaceData;
 
@ClientEndpoint
public class FaceClient {
 
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private static Gson gson = null;
 
    public static void main(String[] args) throws Exception {
        FaceClient.create("localhost", 8025);
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        bufferRead.readLine();
        System.exit(0);
    }

    public static void create(String host, int port) throws Exception {
        if (FaceClient.gson == null) {
            FaceClient.gson = new GsonBuilder().create();
        }
        ClientManager client = ClientManager.createClient();
        client.connectToServer(FaceClient.class, 
            new URI("ws://" + host + ":" + new Integer(8025).toString() + "/faceData"));
    }

    @OnOpen
    public void onOpen(Session session) throws Exception {
        logger.info("Connected ... " + session.getId());
    }
 
    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        logger.info("Received ...." + message);
        FaceData faceData = gson.fromJson(message, FaceData.class);
    }
 
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info(String.format("Session %s close because of %s", session.getId(), closeReason));
    }
 
}