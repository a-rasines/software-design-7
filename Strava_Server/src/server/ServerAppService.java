package server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import server.data.ChallengeDTO;
import server.data.ProfileDTO;
import server.data.TrainingSessionDTO;
import server.data.temp.login.LoginDTO;
import server.data.temp.register.RegisterDTO;
import server.factory.AuthFactory;
import server.remote.Session;

public class ServerAppService {
List<Session> activeSessions;
	
	private AuthFactory aFactory = new AuthFactory(); 
	private List<ProfileDTO> userList = new ArrayList<>();//FIXME Remove when SQL
	static {//FIXME Remove when SQL
		//TODO Add hardcoded users
	}
	//Data structure for manage Server State
	public Map<String, Session> serverState = new HashMap<>();
	
	
	
	public ServerAppService() throws RemoteException {
		super();
		
		
	}
	
	public String register(RegisterDTO profile) throws RemoteException {
		 System.out.println("Register: "+profile.toString());
			//TODO DataBase hacer cuando
			//Perform login() using LoginAppService
	//TODO TODO TODO implementar cuando se haga el Session
			//Session user = LoginAppService.getInstance().login(email, password);
			Session user = new Session();
			
			//If login() success user is stored in the Server State
			if(aFactory.getInstance(profile).authenticate()) {
				return System.currentTimeMillis() +"";
			}
			return ":(";
//			if (user != null) {
//				//If user is not logged in 
//				if (!this.serverState.values().contains(user)) {
//					String token = "";
//					//Auth.getInstance().register(accType, profile, password);	 al pasarlo hacer un case
//					this.serverState.put(token, user);		
//					return(token);
//				} else {
//					//TODO throw new RemoteException("User is already logged in!");
//					return("Couldn't register");
//				}
//			} else {
//				//TODO throw new RemoteException("Login fails!");
//				return("Couldn't register");
//			}
	}
	public String login(LoginDTO profile) throws RemoteException {
		System.out.println("Login: "+profile.toString());
				
				//Perform login() using LoginAppService
		//TODO TODO TODO implementar cuando se haga el Session
				//Session user = LoginAppService.getInstance().login(email, password);
				
				Session user = new Session();
				if(aFactory.getInstance(profile).authenticate()) {
					return System.currentTimeMillis() +"";
				}
				return ":(";
				//If login() success user is stored in the Server State
//				if (user != null) {
//					//If user is not logged in 
//					if (!this.serverState.values().contains(user)) {
//						String token = LoginStrategy.getInstance().login(accType, email, password);		
//						this.serverState.put(token, user);		
//						return(token);
//					} else {
//						//TODO throw new RemoteException("User is already logged in!");
//						return("Couldn't Login");
//					}
//				} else {
//					//TODO throw new RemoteException("Login fails!");
//					return("Couldn't Login");
//				}
	}
	public void logout(String token) throws RemoteException{
		System.out.println(" * RemoteFacade logout: " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			System.out.println("Logout failed");
			throw new RemoteException("User is not not logged in!");
		}
	}
	public TrainingSessionDTO createTrainingSession(String token, TrainingSessionDTO tsDTO ) throws RemoteException{
		System.out.println("training session");
		return tsDTO;
		//TODO
	}
	public ChallengeDTO setUpChallenge(String token, ChallengeDTO challengeDTO) throws RemoteException{
		System.out.println("SetUpChallenge");
		return challengeDTO;
	}
	public boolean acceptChallenge(String token,ChallengeDTO challenge) throws RemoteException{
		System.out.println("accept challenge");
		return true;
	}
	public List<ChallengeDTO> downloadActiveChallenges(String token) throws RemoteException{
		System.out.println("Downloading active challenges");
		return null;
	}
}
