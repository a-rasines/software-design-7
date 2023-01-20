package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import server.data.dto.ChallengeDTO;
import server.data.dto.LoginDTO;
import server.data.dto.RegisterDTO;
import server.data.dto.TrainingSessionDTO;

public interface IRemoteFacade extends Remote {
	//List<Session> activeSessions;
	String register(RegisterDTO profile) throws RemoteException;
	String login(LoginDTO profile) throws RemoteException;
	void logout(String token) throws RemoteException;
	TrainingSessionDTO createTrainingSession(String token, TrainingSessionDTO tsDTO ) throws RemoteException;
	ChallengeDTO setUpChallenge(String token, ChallengeDTO challengeDTO) throws RemoteException;
	boolean acceptChallenge(String token,ChallengeDTO challenge) throws RemoteException;
	List<ChallengeDTO> downloadActiveChallenges(String token) throws RemoteException;
	List<ChallengeDTO> downloadChallenge(String token) throws RemoteException;
	
}
