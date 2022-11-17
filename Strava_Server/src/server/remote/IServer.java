package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import server.data.ChallengeDTO;
import server.data.SportDTO;
import server.data.TrainingSessionDTO;

public interface IServer extends Remote {
	//List<Session> activeSessions;
	String registerByEmail(String email, String password, String name, String birthdate, float weight, float height, float maxHeartRate, float restHeartRate) throws RemoteException;
	String registerByGoogle(String email, String password, String name, String birthdate, float weight, float height, float maxHeartRate, float restHeartRate) throws RemoteException;
	String registerByFacebook(String string, String string2, String string3, String string4, float parseFloat, float parseFloat2, float parseFloat3, float parseFloat4) throws RemoteException;
	String loginByEmail(String email, String password) throws RemoteException;
	String loginByGoogle(String email, String password) throws RemoteException;
	String loginByFacebook(String email, String password) throws RemoteException;
	String logout(String token) throws RemoteException;
	TrainingSessionDTO createTrainingSession(String token, String title, SportDTO sport, float distance, String startDate, float startTime, float duration ) throws RemoteException;
	ChallengeDTO setUpChallenge(String token, String name, String startDate, String endDate, float distanceTarget, float timeTarget, SportDTO sport) throws RemoteException;
	boolean acceptChallenge(String token,ChallengeDTO challenge) throws RemoteException;
	List<ChallengeDTO> downloadActiveChallenges(String token) throws RemoteException;
	
}
