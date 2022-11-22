package gServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GServer extends UnicastRemoteObject implements IGoogle_Server{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8085455040081485835L;

	public GServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String authenticate(String email, String password) throws RemoteException{
		
		if(false) {
			throw new RemoteException("Error");
		}
		//TODO hacer cosas
		System.out.println("EMAIL: " + email + " PASSWORD: "+ password);
		
		return System.currentTimeMillis() + "";
	}
}
