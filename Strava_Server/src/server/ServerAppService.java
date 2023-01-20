package server;

import java.rmi.RemoteException;
import java.util.List;
import server.data.CacheDatabase;
import server.data.domain.Challenge;
import server.data.domain.DataAssembler;
import server.data.domain.Profile;
import server.data.domain.TrainingSession;
import server.data.dto.LoginDTO;
import server.data.dto.RegisterDTO;
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
			return !CacheDatabase.userMap.add(DataAssembler.getInstance().profileFromRegisterDTO(profile)) && AuthFactory.createGateway(DataAssembler.getInstance().loginFromRegisterDTO(profile)).authenticate();

	}
	public boolean login(LoginDTO profile) throws RemoteException {
		System.out.println("Login: "+profile.toString());
		
		//Perform login() using LoginAppService
//TODO TODO TODO implementar cuando se haga el Session
		//Session user = LoginAppService.getInstance().login(email, password);
		return((profile.profileType == ProfileType.EMAIL && new EmailVerifier(DataAssembler.getInstance().loginFromLoginDTO(profile)).authenticate()) || 
				(AuthFactory.createGateway(DataAssembler.getInstance().loginFromLoginDTO(profile)).authenticate() && CacheDatabase.userMap.contains(profile.profileType, profile.getID())));
			

	}
	public TrainingSession createTrainingSession(Profile profile, TrainingSession ts ) throws RemoteException{
		profile.createTrainingSession(ts);		
		return ts;
		
	}
	public Challenge setUpChallenge(Profile profile, Challenge challenge) throws RemoteException{
		profile.setupChallenge(challenge);
		return challenge;
	}
	public boolean acceptChallenge(Profile p,Challenge challenge) throws RemoteException{
		return p.acceptChallenge(challenge);
		
	}
	public List<Challenge> downloadActiveChallenges(String token) throws RemoteException{
		System.out.println("Downloading active challenges");
		return null;
	}
	
	public List<Challenge> downloadChallenges(Profile p){
		return p.downloadChallenge();
	}
}
