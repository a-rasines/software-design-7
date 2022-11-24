package server.remote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import server.data.AccountTypeDTO;
import server.data.ChallengeDTO;
import server.data.ProfileDTO;
import server.data.TrainingSessionDTO;



import java.lang.String;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//TODO moverlo a otra clase 
public class RemoteFacade extends UnicastRemoteObject implements IServer {
	List<Session> activeSessions;
	
	private List<ProfileDTO> userList = new ArrayList<>();//FIXME Remove when SQL
	static {//FIXME Remove when SQL
		//TODO Add hardcoded users
	}
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	public Map<String, Session> serverState = new HashMap<>();
	
	
	
	public RemoteFacade() throws RemoteException {
		super();
		
		
	}
	@Override
	public String register(AccountTypeDTO accType, ProfileDTO profile, String password) throws RemoteException {
		 System.out.println( accType.name() + " Register: " + profile.getEmail() + " / " + password + " name: " + profile.getName() + " weight: " + profile.getWeight() + " Max. Heartbeat: " + profile.getMaxHeartRate() + " Heartbeat in rest position: " + profile.getRestHeartRate());
			//TODO DataBase hacer cuando
			//Perform login() using LoginAppService
	//TODO TODO TODO implementar cuando se haga el Session
			//Session user = LoginAppService.getInstance().login(email, password);
			Session user = new Session();
			
			//If login() success user is stored in the Server State
			if (user != null) {
				//If user is not logged in 
				if (!this.serverState.values().contains(user)) {
					String token = "";
					//Auth.getInstance().register(accType, profile, password);	 al pasarlo hacer un case
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
	public String login(AccountTypeDTO accType, String email, String password) throws RemoteException {
		System.out.println(accType.name() + " login: " + email + " / " + password);
				
				//Perform login() using LoginAppService
		//TODO TODO TODO implementar cuando se haga el Session
				//Session user = LoginAppService.getInstance().login(email, password);
				
				Session user = new Session();
				
				//If login() success user is stored in the Server State
				if (user != null) {
					//If user is not logged in 
					if (!this.serverState.values().contains(user)) {
						String token = LoginStrategy.getInstance().login(accType, email, password);		
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
