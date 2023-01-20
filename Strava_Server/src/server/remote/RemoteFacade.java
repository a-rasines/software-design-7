package server.remote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import server.ServerAppService;
import server.data.CacheDatabase;
import server.data.domain.Challenge;
import server.data.domain.DataAssembler;
import server.data.domain.Profile;
import server.data.dto.ChallengeDTO;
import server.data.dto.LoginDTO;
import server.data.dto.RegisterDTO;
import server.data.dto.TrainingSessionDTO;

import java.lang.String;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//TODO moverlo a otra clase 
public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {
	private static final long serialVersionUID = 1L;
	public Map<String, Session> serverState = new HashMap<>();
	public RemoteFacade() throws RemoteException {
		super();
		
		
	}
	@Override
	public String register(RegisterDTO profile) throws RemoteException {
		 if (ServerAppService.getInstance().register(profile))
			 return generateToken(DataAssembler.getInstance().profileFromRegisterDTO(profile));
		 else
			 throw new RemoteException("Account already exists");
	}
	public String login(LoginDTO profile) throws RemoteException {
		if(ServerAppService.getInstance().login(profile))
			return generateToken(CacheDatabase.userMap.get(profile.profileType, profile.getID()));
		else
			throw new RemoteException("Authentification error");
	}
	public void logout(String token) throws RemoteException{
		if (this.serverState.containsKey(token)) {
			this.serverState.remove(token);
		} else {
			System.out.println("Logout failed");
			throw new RemoteException("User is not not logged in!");
		}
	}
	public TrainingSessionDTO createTrainingSession(String token, TrainingSessionDTO tsDTO ) throws RemoteException{
		return DataAssembler.getInstance().trainingSessionDTOFromTrainingsession(ServerAppService.getInstance().createTrainingSession(serverState.get(token).getUser(), DataAssembler.getInstance().trainingSessionFromTrainingSessionDTO(tsDTO)));
	}
	public ChallengeDTO setUpChallenge(String token, ChallengeDTO challengeDTO) throws RemoteException{
		return DataAssembler.getInstance().challengeDTOFromChallenge(ServerAppService.getInstance().setUpChallenge(serverState.get(token).getUser(), DataAssembler.getInstance().challengeFromChallengeDTO(challengeDTO))); 
	
	}
	public boolean acceptChallenge(String token,ChallengeDTO challenge) throws RemoteException{
		return ServerAppService.getInstance().acceptChallenge(serverState.get(token).getUser(), DataAssembler.getInstance().challengeFromChallengeDTO(challenge));
	}
	public List<ChallengeDTO> downloadActiveChallenges(String token) throws RemoteException{
		//return ServerAppService.getInstance().downloadActiveChallenges(token);
		return null;
		//TODO canal nose haz tu magia
	}
	
	public List<ChallengeDTO> downloadChallenge(String token) throws RemoteException{
		List<Challenge> liCha = serverState.get(token).getUser().downloadChallenge();
		List<ChallengeDTO> liChaDTO = new ArrayList<ChallengeDTO>();
		for(Challenge c : liCha) {
			liChaDTO.add(DataAssembler.getInstance().challengeDTOFromChallenge(c));
		}
		return liChaDTO;
	}
	
	public String generateToken(Profile profile) {
		String token = System.currentTimeMillis() + "";
		serverState.put(token, new Session(profile, token));
		return token;
	}


}
