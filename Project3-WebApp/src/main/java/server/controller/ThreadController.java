package server.controller;

import server.service.FaceServer;
import server.view.DetectionPanel;
import server.view.EmoticonComposer;

public class ThreadController implements Runnable {

	static Thread th;
	DetectionPanel dpanel ; 
	Double emointerval = 1.0;
	Double timeElapsed = 0.0;
public ThreadController(Double emointerval, DetectionPanel dpanel ){
		
	th= new Thread(this);
	this.dpanel=dpanel;
	this.emointerval= emointerval;
	timeElapsed = Double.parseDouble(dpanel.timeElapsedTextbox.getText());
	}
	
	public void run() {
		while(true){
			
			timeElapsed += emointerval;
			//System.out.println(timeElapsed);
			dpanel.timeElapsedTextbox.setText(timeElapsed+"");
			try {
				th.sleep((long) (1000 * emointerval));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		FaceServer.put(dpanel.getDetectionController().createFaceDataInstance());
		}
	}

	public static void stop() {
		th.stop();
	}
	
	public static void start(){
	
		th.start();
	}
}
