package server.strategy;

import java.rmi.RemoteException;

import googleConect.GServerController;


public class GoogleGateway {

	public static boolean authenticate(String email, String password) {
		
		try {
			return GServerController.authenticate(email, password);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.err.println("Error authenticating");
			return false;
		}
		
	}
}
