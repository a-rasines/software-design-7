package server.remote;

import java.rmi.RemoteException;
import java.util.List;

import server.data.ChallengeDTO;
import server.data.TrainingSessionDTO;

public class ClientController{

	public static void setServerHandler(ServiceLocator sv) {
		handler = sv;
	}
	private static ServiceLocator handler;
	private static String token;
	public static void setToken(String token) {
		ClientController.token = token;
	}
	public static String registerByEmail(String email, String password, String name, String birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		return handler.getService().registerByEmail(email, password, name, birthdate, weight, height, maxHeartRate, restHeartRate);
	}
	public static String registerByGoogle(String email, String password, String name, String birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		return handler.getService().registerByGoogle(email, password, name, birthdate, weight, height, maxHeartRate, restHeartRate);
	}
	public static String registerByFacebook(String string, String string2, String string3, String string4, float parseFloat,
			float parseFloat2, float parseFloat3, float parseFloat4) throws RemoteException {
		return handler.getService().registerByFacebook(string, string2, string3, string4, parseFloat, parseFloat2, parseFloat3, parseFloat4);
	}
	public static String loginByEmail(String email, String password) throws RemoteException {
		return handler.getService().loginByEmail(email, password);
	}
	public static String loginByGoogle(String email, String password) throws RemoteException {
		return handler.getService().loginByGoogle(email, password);
	}
	public static String loginByFacebook(String email, String password) throws RemoteException {
		return null;
	}
	public static String logout() throws RemoteException {
		return handler.getService().logout(token);
	}
	public TrainingSessionDTO createTrainingSession(TrainingSessionDTO tsDTO) throws RemoteException {
		return handler.getService().createTrainingSession(token, tsDTO);
	}
	public ChallengeDTO setUpChallenge(ChallengeDTO challengeDTO) throws RemoteException {
		return handler.getService().setUpChallenge(token, challengeDTO);
	}
	public boolean acceptChallenge(ChallengeDTO challenge) throws RemoteException {
		return handler.getService().acceptChallenge(token, challenge);
	}
	public List<ChallengeDTO> downloadActiveChallenges() throws RemoteException {
		return handler.getService().downloadActiveChallenges(token);
	}
}
