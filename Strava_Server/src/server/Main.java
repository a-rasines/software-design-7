package server;

import java.rmi.Naming;

import server.remote.IServer;
import server.remote.Server;

public class Main {
	
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2]; // //ip:port/name
		try {
			IServer server = new Server();
			Naming.rebind(name, server);
			System.out.println("Server started on " +  name);
		} catch (Exception e) {
			System.err.println("Couldn't start server on " + name);
			e.printStackTrace();
		}
	}
	
}