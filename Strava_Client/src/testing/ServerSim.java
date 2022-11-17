package testing;

import java.rmi.RemoteException;
import java.util.List;

import server.data.ChallengeDTO;
import server.data.TrainingSessionDTO;
import server.remote.IServer;

public class ServerSim implements IServer{

	@Override
	public String registerByEmail(String email, String password, String name, String birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) {
		return "";
	}

	@Override
	public String registerByGoogle(String email, String password, String name, String birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) {
		return "";
	}

	@Override
	public String registerByFacebook(String email, String password, String name, String birthdate, float weight,
			float height, float maxHeartRate, float restHeartRate) {
		return "";
	}

	@Override
	public String loginByEmail(String email, String password) {
		return "";
	}

	@Override
	public String loginByGoogle(String email, String password) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String loginByFacebook(String email, String password) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String logout(String token) throws RemoteException {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public TrainingSessionDTO createTrainingSession(String token, TrainingSessionDTO tsDTO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChallengeDTO setUpChallenge(String token, ChallengeDTO challengeDTO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptChallenge(String token, ChallengeDTO challenge) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ChallengeDTO> downloadActiveChallenges(String token) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
