package gServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class GServer extends UnicastRemoteObject implements IGoogle_Server{
	private static HashMap<String, String> userMap = new HashMap<>();//FIXME Remove when SQL
	
	static {//FIXME Remove when SQL
		userMap.put("test@example.com", "securepassword1234");
		userMap.put("mail@domain.com", "abcdepassword_");
		userMap.put("deusto@deusto.es", "bilbao123");
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 8085455040081485835L;

	public GServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean authenticate(String email, String password) throws RemoteException{
		
		if(!userMap.containsKey(email)) {
			throw new RemoteException("User not found");
		}else if(!userMap.get(email).equals(password)) {
			throw new RemoteException("User or password incorrect");
		}
		//TODO hacer cosas
		System.out.println("EMAIL: " + email + " PASSWORD: "+ password);
		
		return true;
	}
}
