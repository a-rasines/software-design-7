package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import server.data.AccountTypeDTO;
import server.data.ChallengeDTO;
import server.data.ProfileDTO;
import server.data.SportDTO;
import server.data.TrainingSessionDTO;

public interface IServer extends Remote {
	//List<Session> activeSessions;
	String register(AccountTypeDTO accType, ProfileDTO profile, String password) throws RemoteException;
	String login(AccountTypeDTO accType, String email, String password) throws RemoteException;
	String logout(String token) throws RemoteException;
	TrainingSessionDTO createTrainingSession(String token, TrainingSessionDTO tsDTO ) throws RemoteException;
	ChallengeDTO setUpChallenge(String token, ChallengeDTO challengeDTO) throws RemoteException;
	boolean acceptChallenge(String token,ChallengeDTO challenge) throws RemoteException;
	List<ChallengeDTO> downloadActiveChallenges(String token) throws RemoteException;
	
}
