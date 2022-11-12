package server.remote;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.lang.String;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements IServer {
	List<Session> activeSessions;
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	public Map<String, Session> serverState = new HashMap<>();
	
	public Server() throws RemoteException {
		super();
	}
	
	 public String registerByEmail(String email, String password, String name, String birthdate, String weight, String height, int maxHeartRate) {
		 System.out.println(" * Email register: " + email + " / " + password + " name: " + name + " weight: " + weight + " Heartbeat: " + maxHeartRate);
			//TODO DataBase hacer cuando
			//Perform login() using LoginAppService
	//TODO TODO TODO implementar cuando se haga el Session
			//Session user = LoginAppService.getInstance().login(email, password);
			Session user = new Session();
			
			//If login() success user is stored in the Server State
			if (user != null) {
				//If user is not logged in 
				if (!this.serverState.values().contains(user)) {
					String token = ""+ Calendar.getInstance().getTimeInMillis();		
					this.serverState.put(token, user);		
					return(token);
				} else {
					//TODO throw new RemoteException("User is already logged in!");
					return("Couldn't register");
				}
			} else {
				//TODO throw new RemoteException("Login fails!");
				return("Couldn't register");
			}
	}
	public String registerByGoogle(String email, String password, String name, String birthdate, String weight, String height, int maxHeartRate) {
		System.out.println(" * Google Register: " + email + " / " + password + " name: " + name + " weight: " + weight + " Heartbeat: " + maxHeartRate);
		//TODO cuando haya DB
		//Perform login() using LoginAppService
//TODO TODO TODO implementar cuando se haga el Session
		//Session user = LoginAppService.getInstance().login(email, password);
		Session user = new Session();
		
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				String token = ""+ Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				//TODO throw new RemoteException("User is already logged in!");
				return("Couldn't Register");
			}
		} else {
			//TODO throw new RemoteException("Login fails!");
			return("Couldn't Register");
		}
	}
	public String registerByFacebook(String email, String password, String name, String birthdate, String weight, String height, int maxHeartRate) {
		System.out.println(" * FaceBook Register: " + email + " / " + password + " name: " + name + " weight: " + weight + " Heartbeat: " + maxHeartRate);
		//TODO cuando haya base de datos
		//Perform login() using LoginAppService
//TODO TODO TODO implementar cuando se haga el Session
		//Session user = LoginAppService.getInstance().login(email, password);
		Session user = new Session();
		
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				String token = ""+ Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				//TODO throw new RemoteException("User is already logged in!");
				return("Couldn't Register");
			}
		} else {
			//TODO throw new RemoteException("Login fails!");
			return("Couldn't Register");
		}
	}
	public String loginByEmail(String email, String password) {
		System.out.println(" * Email login: " + email + " / " + password);
				
				//Perform login() using LoginAppService
		//TODO TODO TODO implementar cuando se haga el Session
				//Session user = LoginAppService.getInstance().login(email, password);
				Session user = new Session();
				
				//If login() success user is stored in the Server State
				if (user != null) {
					//If user is not logged in 
					if (!this.serverState.values().contains(user)) {
						String token = ""+ Calendar.getInstance().getTimeInMillis();		
						this.serverState.put(token, user);		
						return(token);
					} else {
						//TODO throw new RemoteException("User is already logged in!");
						return("Couldn't Login");
					}
				} else {
					//TODO throw new RemoteException("Login fails!");
					return("Couldn't Login");
				}
	}
	public String loginByGoogle(String email, String password) {
		System.out.println(" * Google login: " + email + " / " + password);
				
				//Perform login() using LoginAppService
		//TODO TODO TODO implementar cuando se haga el Session
				//Session user = LoginAppService.getInstance().login(email, password);
				Session user = new Session();
				
				//If login() success user is stored in the Server State
				if (user != null) {
					//If user is not logged in 
					if (!this.serverState.values().contains(user)) {
						String token = ""+ Calendar.getInstance().getTimeInMillis();		
						this.serverState.put(token, user);		
						return(token);
					} else {
						//TODO throw new RemoteException("User is already logged in!");
						return("Couldn't Login");
					}
				} else {
					//TODO throw new RemoteException("Login fails!");
					return("Couldn't Login");
				}
	}
	public String loginByFacebook(String email, String password) {
		System.out.println(" * Facebook login: " + email + " / " + password);
		
		//Perform login() using LoginAppService
//TODO TODO TODO implementar cuando se haga el Session
		//Session user = LoginAppService.getInstance().login(email, password);
		Session user = new Session();
		
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				String token = ""+ Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				//TODO throw new RemoteException("User is already logged in!");
				return("Couldn't Login");
			}
		} else {
			//TODO throw new RemoteException("Login fails!");
			return("Couldn't Login");
		}
	}
	public String logout(String token) throws RemoteException{
		System.out.println(" * RemoteFacade logout: " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			System.out.println("Logout failed");
			throw new RemoteException("User is not not logged in!");
		}
		return null;
	}
}
