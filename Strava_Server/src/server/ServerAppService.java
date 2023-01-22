package server;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import server.data.dao.EmailProfileDAO;
import server.data.dao.ProfileDAO;
import server.data.domain.Challenge;
import server.data.domain.DataAssembler;
import server.data.domain.EmailProfile;
import server.data.domain.Login;
import server.data.domain.Profile;
import server.data.domain.TrainingSession;
import server.data.dto.RegisterDTO;
import server.data.enums.ProfileType;
import server.factory.AuthFactory;
import server.factory.EmailVerifier;
import server.gateway.MailSender;

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
		 System.out.println(p);
		 if(p == null)
			 if(profile.getType() == ProfileType.EMAIL) {
				 System.out.println("Saving new email");
				EmailProfileDAO.getInstance().save((EmailProfile)DataAssembler.getInstance().profileFromRegisterDTO(profile));
				return true;
			 }else if(AuthFactory.createGateway(DataAssembler.getInstance().loginFromRegisterDTO(profile)).authenticate()) {
				 ProfileDAO.getInstance().save(DataAssembler.getInstance().profileFromRegisterDTO(profile));
				 return true;
			 }else return false;
		 else return false;

	}
	public boolean login(Login profile) throws RemoteException {
		System.out.println("Login: "+profile.toString());
		Profile p = profile.profileType==ProfileType.EMAIL?EmailProfileDAO.getInstance().find(profile.email) :ProfileDAO.getInstance().find(profile.email, profile.profileType);
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
		System.out.println("Create Training Session");
		profile.createTrainingSession(ts);		
		return ts;
		
	}
	public Challenge setUpChallenge(Profile profile, Challenge challenge) throws RemoteException{
		System.out.println("Create Challenge");
		profile.setupChallenge(challenge);
		new MailSender("aimar.jimenez@opendeusto.es").sendMessage("Challenge made");
		return challenge;
	}
	public boolean acceptChallenge(Profile p,Challenge challenge) throws RemoteException{
		System.out.println("Accept Challenge");
		return p.acceptChallenge(challenge);
		
	}
	public Map<Challenge, Byte> downloadActiveChallenges(Profile p) throws RemoteException{
		System.out.println("Downloading active challenges");
		return p.downloadActiveChallenges();
	}
	
	public List<Challenge> downloadCompletedChallenges(Profile p) throws RemoteException{
		System.out.println("Downloading completed challenges");
		return p.downloadCompletedChallenges();
	}
	public List<TrainingSession> downloadTrainingSessions(Profile p) throws RemoteException{
		System.out.println("Download Training Sessions");
		return (List<TrainingSession>) p.getSessions();
	}
	
	public List<Challenge> downloadChallenges(Profile p){
		System.out.println("Downloading workshop challenges");
		return p.downloadChallenge();
	}
}
