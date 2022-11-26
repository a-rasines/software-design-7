package server;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import server.data.CacheDatabase;
import server.data.ChallengeDTO;
import server.data.ProfileDTO;
import server.data.TrainingSessionDTO;
import server.data.temp.login.LoginDTO;
import server.data.temp.register.RegisterDTO;
import server.factory.AuthFactory;
import server.remote.Session;

public class ServerAppService {
	
	private AuthFactory aFactory = new AuthFactory(); 
	//Data structure for manage Server State
	public Map<String, Session> serverState = new HashMap<>();
	
	
	
	public ServerAppService() throws RemoteException {
		super();
		
		
	}
	
	public String register(RegisterDTO profile) throws RemoteException {
		 System.out.println(profile.getProfile().getClass().getSimpleName().replace("DTO", "").replace("Register", " Register")+": "+profile.getProfile().getEmail());
			//TODO DataBase hacer cuando
			//Perform login() using LoginAppService
	//TODO TODO TODO implementar cuando se haga el Session
			if(!CacheDatabase.userMap.add(profile.getProfile()))
				throw new RemoteException("The account already exists");
			//If login() success user is stored in the Server State
			if(aFactory.getInstance(profile).authenticate()) {
				return generateToken(profile.getProfile());
			}else
				throw new RemoteException("Something went wrong");
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
		if(aFactory.getInstance(profile).authenticate() && CacheDatabase.userMap.contains(profile.getReferredProfileType(), profile.getID())) {
			return generateToken(CacheDatabase.userMap.get(profile.getReferredProfileType(), profile.getID()));
		}else
			throw new RemoteException("Authentification error");
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
	public String generateToken(ProfileDTO profile) {
		String token = System.currentTimeMillis() + "";
		serverState.put(token, new Session(profile, token));
		return token;
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
