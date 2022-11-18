package testing;

import java.rmi.RemoteException;
import java.util.List;

import server.data.AccountTypeDTO;
import server.data.ChallengeDTO;
import server.data.ProfileDTO;
import server.data.TrainingSessionDTO;
import server.remote.IServer;

public class ServerSim implements IServer{

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

	@Override
	public String register(AccountTypeDTO accType, ProfileDTO profile, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login(AccountTypeDTO accType, String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
