package server;

import java.rmi.RemoteException;
import java.util.List;
import server.data.dao.ProfileDAO;
import server.data.domain.Challenge;
import server.data.domain.DataAssembler;
import server.data.domain.Login;
import server.data.domain.Profile;
import server.data.domain.TrainingSession;
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
		 Profile p = ProfileDAO.getInstance().find(profile.getEmail(), profile.getType());
		 if( p == null && (profile.getType() == ProfileType.EMAIL || AuthFactory.createGateway(DataAssembler.getInstance().loginFromRegisterDTO(profile)).authenticate())) {
			 ProfileDAO.getInstance().save(DataAssembler.getInstance().profileFromRegisterDTO(profile));
			 return true;
		 }else return false;

	}
	public boolean login(Login profile) throws RemoteException {
		System.out.println("Login: "+profile.toString());
		Profile p = ProfileDAO.getInstance().find(profile.email, profile.profileType);
		return 
				p != null
				&& 
				(
					(
						profile.profileType == ProfileType.EMAIL 
						&& 
						new EmailVerifier(profile).authenticate()
					)
					|| 
					AuthFactory.createGateway(profile).authenticate() 
				);
			

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
	public List<Challenge> downloadActiveChallenges(Profile p) throws RemoteException{
		System.out.println("Downloading active challenges");
		return p.downloadActiveChallenges();
	}
	
	public List<Challenge> downloadCompletedChallenges(Profile p) throws RemoteException{
		System.out.println("Downloading completed challenges");
		return p.downloadCompletedChallenges();
	}
	@SuppressWarnings("unchecked")
	public List<TrainingSession> downloadTrainingSessions(Profile p) throws RemoteException{
		return (List<TrainingSession>) p.getSessions();
	}
	
	public List<Challenge> downloadChallenges(Profile p){
		return p.downloadChallenge();
	}
}
