package server.remote;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import server.data.ChallengeDTO;
import server.data.SportDTO;
import server.data.TrainingSessionDTO;

import java.lang.String;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteFacade extends UnicastRemoteObject implements IServer {
	List<Session> activeSessions;
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	public Map<String, Session> serverState = new HashMap<>();
	
	public RemoteFacade() throws RemoteException {
		super();
	}
	
	public String registerByEmail(String email, String password, String name, String birthdate, float weight, float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		 System.out.println(" * Email Register: " + email + " / " + password + " name: " + name + " weight: " + weight + " Max. Heartbeat: " + maxHeartRate + " Heartbeat in rest position: " + restHeartRate);
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
	public String registerByGoogle(String email, String password, String name, String birthdate, float weight, float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		System.out.println(" * Google Register: " + email + " / " + password + " name: " + name + " weight: " + weight + " Max. Heartbeat: " + maxHeartRate + " Heartbeat in rest position: " + restHeartRate);
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
	public String registerByFacebook(String email, String password, String name, String birthdate, float weight, float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		System.out.println(" * Facebook Register: " + email + " / " + password + " name: " + name + " weight: " + weight + " Max. Heartbeat: " + maxHeartRate + " Heartbeat in rest position: " + restHeartRate);
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
	public String loginByEmail(String email, String password) throws RemoteException {
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
	public String loginByGoogle(String email, String password) throws RemoteException {
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
	public String loginByFacebook(String email, String password) throws RemoteException {
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
	public TrainingSessionDTO createTrainingSession(String token, String title, SportDTO sport, float distance, String startDate, float startTime, float duration ) throws RemoteException{
		throw new RemoteException();
		//TODO
	}
	public ChallengeDTO setUpChallenge(String token, String name, String startDate, String endDate, float distanceTarget, float timeTarget, SportDTO sport) throws RemoteException{
		throw new RemoteException();
	}
	public boolean acceptChallenge(String token,ChallengeDTO challenge) throws RemoteException{
		throw new RemoteException();
	}
	public List<ChallengeDTO> downloadActiveChallenges(String token) throws RemoteException{
		throw new RemoteException();
	}


}
