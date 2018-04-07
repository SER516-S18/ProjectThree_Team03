package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuController {

	public MenuController(JMenuItem about, JMenuItem exit ){
		about.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Emoticon Application. Version 1.0");
			}
		});
		
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
			}
		});
	}
	
}
