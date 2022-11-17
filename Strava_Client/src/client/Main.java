package client;

import client.gui.ClientWindow;

import server.remote.ServiceLocator;

public class Main {
	
	public static void main(String[] args) {
		ServiceLocator handler = new ServiceLocator();
		handler.setService(args[0], args[1], args[2]);
		
		new ClientWindow(handler);
		
	}
	
}