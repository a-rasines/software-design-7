package client;

import client.remote.ServerHandler;

public class Main {
	
	public static void main(String[] args) {
		ServerHandler handler = new ServerHandler();
		handler.setService(args[0], args[1], args[2]);
		
	}
	
}