package server;

import java.io.IOException;
import java.rmi.Naming;

import server.factory.FacebookGateway;
import server.factory.GoogleGateway;
import server.remote.IRemoteFacade;
import server.remote.RemoteFacade;


public class Main {
	
	public static void main(String[] args) {
		System.out.println("Connecting to Google_Server");
		try {
			GoogleGateway.setService(args[3], args[4] , args[5]);
			System.out.println("Connected to Google_Server");
		} catch (Exception e) {
			System.err.println("Failed to conect to Google_Server\t\t\t▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
			e.printStackTrace();
		}
		System.out.println("Connecting to Facebook_Server");
		try {
			FacebookGateway.setupSocket(args[6], Integer.parseInt(args[7]));
			System.out.println("Connected to Facebook_Server");
		} catch (NumberFormatException | IOException e1) {
			System.err.println("Failed to conect to Facebook_Server\t\t\t▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
			e1.printStackTrace();
		}
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2]; // //ip:port/name
		try {
			IRemoteFacade server = new RemoteFacade();
			Naming.rebind(name, server);
			System.out.println("Server started on " +  name);
		} catch (Exception e) {
			System.err.println("Couldn't start server on " + name);
			e.printStackTrace();
		}
		
	}
	
}