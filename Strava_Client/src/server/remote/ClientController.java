package server.remote;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import server.data.AccountTypeDTO;
import server.data.ChallengeDTO;
import server.data.ProfileDTO;
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
	public static String registerByEmail(String email, String password, String name, Date birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		return handler.getService().register(AccountTypeDTO.EMAIL, new ProfileDTO.Builder(AccountTypeDTO.EMAIL, name, birthdate, email).weight(weight).height(weight).maxHeartRate(maxHeartRate).password(password).build(), password);
	}
	public static String registerByGoogle(String email, String password, String name, Date birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		return handler.getService().register(AccountTypeDTO.GOOGLE, new ProfileDTO.Builder(AccountTypeDTO.GOOGLE, name, birthdate, email).weight(weight).height(weight).maxHeartRate(maxHeartRate).build(), password);
	}
	public static String registerByFacebook(String email, String password, String name, Date birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) throws RemoteException {
		return handler.getService().register(AccountTypeDTO.FACEBOOK, new ProfileDTO.Builder(AccountTypeDTO.FACEBOOK, name, birthdate, email).weight(weight).height(weight).maxHeartRate(maxHeartRate).build(), password);
	}
	public static String loginByEmail(String email, String password) throws RemoteException {
		return handler.getService().login(AccountTypeDTO.EMAIL, email, password);
	}
	public static String loginByGoogle(String email, String password) throws RemoteException {
		return handler.getService().login(AccountTypeDTO.GOOGLE, email, password);
	}
	public static String loginByFacebook(String email, String password) throws RemoteException {
		return handler.getService().login(AccountTypeDTO.FACEBOOK, email, password);
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
