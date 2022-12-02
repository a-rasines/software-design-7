package server;

import java.rmi.RemoteException;
import java.util.List;
import server.data.CacheDatabase;
import server.data.domain.DomainAssembler;
import server.data.dto.ChallengeDTO;
import server.data.dto.LoginDTO;
import server.data.dto.RegisterDTO;
import server.data.dto.TrainingSessionDTO;
import server.data.enums.ProfileType;
import server.factory.AuthFactory;
import server.factory.EmailVerifier;

public class ServerAppService {
	private static final ServerAppService instance = new ServerAppService();
	public static ServerAppService getInstance() {
		return instance;
	}
	
	//Data structure for manage Server State
	
	private ServerAppService(){}
	
	public boolean register(RegisterDTO profile) throws RemoteException {
		 System.out.println(profile.getType().toString()+" Register: "+profile.getEmail());
			//TODO DataBase hacer cuando
			//Perform login() using LoginAppService
	//TODO TODO TODO implementar cuando se haga el Session
			return !CacheDatabase.userMap.add(DomainAssembler.profileFromRegisterDTO(profile)) && AuthFactory.createGateway(DomainAssembler.loginFromRegisterDTO(profile)).authenticate();
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
	public boolean login(LoginDTO profile) throws RemoteException {
		System.out.println("Login: "+profile.toString());
		
		//Perform login() using LoginAppService
//TODO TODO TODO implementar cuando se haga el Session
		//Session user = LoginAppService.getInstance().login(email, password);
		return((profile.profileType == ProfileType.EMAIL && new EmailVerifier(profile).authenticate()) || 
				(AuthFactory.createGateway(DomainAssembler.loginFromLoginDTO(profile)).authenticate() && CacheDatabase.userMap.contains(profile.profileType, profile.getID())));
			
			
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
