package testing;

import java.rmi.RemoteException;

import client.remote.IServer;

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

}
