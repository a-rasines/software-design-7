package client.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
	//List<Session> activeSessions;
	String registerByEmail(String email, String password, String name, String birthdate, float weight, float height, float maxHeartRate, float restHeartRate);
	String registerByGoogle(String email, String password, String name, String birthdate, float weight, float height, float maxHeartRate, float restHeartRate);
	String registerByFacebook(String email, String password, String name, String birthdate, float weight, float height, float maxHeartRate, float restHeartRate);
	String loginByEmail(String email, String password);
	String loginByGoogle(String email, String password);
	String loginByFacebook(String email, String password);
	String logout(String token) throws RemoteException;
}
