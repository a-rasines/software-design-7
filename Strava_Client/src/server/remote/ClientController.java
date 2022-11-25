package server.remote;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import server.data.ChallengeDTO;
import server.data.TrainingSessionDTO;
import server.data.temp.login.EmailLoginDTO;
import server.data.temp.login.FacebookLoginDTO;
import server.data.temp.login.GoogleLoginDTO;
import server.data.temp.register.EmailRegisterDTO;
import server.data.temp.register.FacebookRegisterDTO;
import server.data.temp.register.GoogleRegisterDTO;

public class ClientController{

	public static void setServerHandler(ServiceLocator sv) {
		handler = sv;
	}
	private static ServiceLocator handler;
	private static String token;
	public static void setToken(String token) {
		ClientController.token = token;
	}
	public static void registerByEmail(String email, String password, String name, Date birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		token = handler.getService().register(
				new EmailRegisterDTO(
						name, 
						birthdate, 
						weight, 
						height,
						maxHeartRate, 
						restHeartRate, 
						email, 
						password));
	}
	public static void registerByGoogle(String email, String password, String name, Date birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		token = handler.getService().register(
				new GoogleRegisterDTO(
						name, 
						birthdate, 
						weight,
						height,
						maxHeartRate, 
						restHeartRate,
						email, 
						password));
	}
	public static void registerByFacebook(String email, String password, String name, Date birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		token = handler.getService().register(
				new FacebookRegisterDTO(
						name, 
						birthdate, 
						weight, 
						height, 
						maxHeartRate,
						restHeartRate, 
						email, 
						password));
	}
	public static void loginByEmail(String email, String password) throws RemoteException {
		token= handler.getService().login(new EmailLoginDTO(email, password));
	}
	public static void loginByGoogle(String email, String password) throws RemoteException {
		token= handler.getService().login(new GoogleLoginDTO(email, password));
	}
	public static void loginByFacebook(String email, String password) throws RemoteException {
		token= handler.getService().login(new FacebookLoginDTO(email, password));
	}
	public static void logout() throws RemoteException {
		handler.getService().logout(token);
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
