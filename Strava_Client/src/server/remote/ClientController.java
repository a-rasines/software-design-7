package server.remote;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import server.data.dto.ChallengeDTO;
import server.data.dto.LoginDTO;
import server.data.dto.ProfileTypeDTO;
import server.data.dto.RegisterDTO;
import server.data.dto.TrainingSessionDTO;

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
				new RegisterDTO(
						password, 
						ProfileTypeDTO.EMAIL, 
						name,
						birthdate,
						weight, 
						height,  
						maxHeartRate, 
						restHeartRate, 
						email
					));
	}
	public static void registerByGoogle(String email, String password, String name, Date birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		token = handler.getService().register(
				new RegisterDTO(
						password,
						ProfileTypeDTO.GOOGLE,
						name,
						birthdate, 
						weight,
						height,
						maxHeartRate, 
						restHeartRate,
						email
					));
	}
	public static void registerByFacebook(String email, String password, String name, Date birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		token = handler.getService().register(
				new RegisterDTO(
						password,
						ProfileTypeDTO.FACEBOOK,
						name, 
						birthdate, 
						weight, 
						height, 
						maxHeartRate,
						restHeartRate, 
						email
					));
	}
	public static void loginByEmail(String email, String password) throws RemoteException {
		token= handler.getService().login(new LoginDTO(email, password, ProfileTypeDTO.EMAIL));
	}
	public static void loginByGoogle(String email, String password) throws RemoteException {
		token= handler.getService().login(new LoginDTO(email, password, ProfileTypeDTO.GOOGLE));
	}
	public static void loginByFacebook(String email, String password) throws RemoteException {
		token= handler.getService().login(new LoginDTO(email, password, ProfileTypeDTO.FACEBOOK));
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
