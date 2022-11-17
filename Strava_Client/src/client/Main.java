package client;

import client.gui.ClientWindow;
import server.remote.ClientController;
import server.remote.ServiceLocator;

public class Main {
	
	public static void main(String[] args) {
		ClientController.setServerHandler(new ServiceLocator(args[0], args[1], args[2]));
		
		new ClientWindow();
		
	}
	
}