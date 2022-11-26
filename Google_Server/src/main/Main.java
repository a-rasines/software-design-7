package main;

import java.rmi.Naming;

import gServer.GServer;
import gServer.IGoogle_Server;


public class Main {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2]; // //ip:port/name
		try {
			IGoogle_Server server = new GServer();
			
			Naming.rebind(name, server);
			
			System.out.println("Server started on " +  name);
		} catch (Exception e) {
			System.err.println("Couldn't start server on " + name);
			e.printStackTrace();
		}
	}
}
