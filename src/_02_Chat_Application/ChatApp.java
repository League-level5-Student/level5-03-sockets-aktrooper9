package _02_Chat_Application;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import _00_Click_Chat.gui.ButtonClicker;
import _00_Click_Chat.networking.Client;
import _00_Click_Chat.networking.Server;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {
	Server2 server;
	Client2 client;
	
	
	public static void main(String[] args) {
		new ChatApp();
		System.out.println("Chat");
	}
	
	public ChatApp(){
		int response = JOptionPane.showConfirmDialog(null, "Would you like to host a connection?", "ChatApp!", JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION){
			server = new Server2(8080);
			JOptionPane.showMessageDialog(null, "Server started at: " + server.getIPAddress() + "\nPort: " + server.getPort());
			JOptionPane.showInputDialog("message");
			server.start();
			
		}else{	
		String ipStr = JOptionPane.showInputDialog("Enter the IP Address");
		String prtStr = JOptionPane.showInputDialog("Enter the port number");
		int port = Integer.parseInt(prtStr);
		client = new Client2(ipStr, port);
			client.start();
		}
	}
}
