package client;

/**
 * @SER516 Project3_Team03
 * @Version 1.0
 */

import javax.swing.JTextArea;

/**
* This class is used for logging messages to the 
* GUI console.
*/
public  class ClientConsole {

    protected JTextArea consolePane;
    private static ClientConsole instance = null;
    
    /**
    * Sets the GUI console text to the provided message.
    *
    * @param msg text to display in the GUI console.
    */
  
    public void print(String msg) {
        this.consolePane.setText("Console: " + msg);
    }

    /**
    * Setter for the target GUI element.
    *
    * @param consolePane the pane to which logged messages will appear.
    */
    
    public void setJtextArea(JTextArea consolePane) {
        this.consolePane = consolePane;
    }
    
    /*
     * getInstance returns the ServerConsole object
     *
     */
     
     public static ClientConsole getInstance() {
         if (instance == null) {
             instance = new ClientConsole();
         }
         return instance;
     }
     
 }


