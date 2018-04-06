package client.controller;

import java.awt.Color;

import client.view.ColorSelectorButton;
import client.view.ColorSelectorButton.ColorChangedListener;

public class ChangeColorController {
	public ChangeColorController(ColorSelectorButton button) {
		button.addColorChangedListener(new ColorChangedListener() {

		    public void colorChanged(Color newColor) {
		            // do something with newColor ...
		    		System.out.println("New Color is selected!");
		    		
		    	
		    }
		});
	}
}
