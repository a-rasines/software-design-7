package server.remote;

import java.util.List;
import server.ServerAppService;
import server.data.ChallengeDTO;
import server.data.TrainingSessionDTO;
import server.data.temp.login.LoginDTO;
import server.data.temp.register.RegisterDTO;

import java.lang.String;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//TODO moverlo a otra clase 
public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {
	private static final long serialVersionUID = 1L;
	
	ServerAppService sas = new ServerAppService();
	
	public RemoteFacade() throws RemoteException {
		super();
		
		
	}
	@Override
	public String register(RegisterDTO profile) throws RemoteException {
		 return sas.register(profile);
	}
	public String login(LoginDTO profile) throws RemoteException {
		return sas.login(profile);
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
