package server.remote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import server.ServerAppService;
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
	
	ServerAppService sas = new ServerAppService();
	
	public RemoteFacade() throws RemoteException {
		super();
		
		
	}
	@Override
	public String register(AccountTypeDTO accType, ProfileDTO profile, String password) throws RemoteException {
		 return sas.register(accType, profile, password);
	}
	public String login(AccountTypeDTO accType, String email, String password) throws RemoteException {
		return sas.login(accType, email, password);
	}
	public void logout(String token) throws RemoteException{
		sas.logout(token);
	}
	public TrainingSessionDTO createTrainingSession(String token, TrainingSessionDTO tsDTO ) throws RemoteException{
		return sas.createTrainingSession(token, tsDTO);
	}
	public ChallengeDTO setUpChallenge(String token, ChallengeDTO challengeDTO) throws RemoteException{
		return sas.setUpChallenge(token, challengeDTO);
	}
	public boolean acceptChallenge(String token,ChallengeDTO challenge) throws RemoteException{
		return sas.acceptChallenge(token, challenge);
	}
	public List<ChallengeDTO> downloadActiveChallenges(String token) throws RemoteException{
		return sas.downloadActiveChallenges(token);
	}


}
