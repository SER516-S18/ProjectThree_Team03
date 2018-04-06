package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

public class InteractiveController {

	JButton btnSend;
	JSpinner emoStateInterval;
	JCheckBox chckbxAuroReset;
	
	public InteractiveController(JButton btnSend,JSpinner emoStateInterval, JCheckBox chckbxAutoReset){
	
		this.btnSend=btnSend;
		this.emoStateInterval = emoStateInterval;
		this.chckbxAuroReset = chckbxAutoReset;
		
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Send");
				
			}
		});
	}
}
