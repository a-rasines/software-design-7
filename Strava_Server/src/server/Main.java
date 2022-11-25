package server;

import java.rmi.Naming;

import googleConect.GServerController;
import googleConect.GServiceLocator;
import server.remote.IRemoteFacade;
import server.remote.RemoteFacade;


public class Main {
	
	public static void main(String[] args) {
		
		try {
			GServerController.setServerHandler(new GServiceLocator("127.0.0.1", "1099" , "Google_Server"));
			System.out.println("Connected to Google_Server");
		} catch (Exception e) {
			System.err.println("Failed to conect to Google_Server");
			e.printStackTrace();
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