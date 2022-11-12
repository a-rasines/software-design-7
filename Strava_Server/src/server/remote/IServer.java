package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
	//List<Session> activeSessions;
	String registerByEmail(String email, String password, String name, String birthdate, String weight, String height, int maxHeartRate);
	String registerByGoogle(String email, String password, String name, String birthdate, String weight, String height, int maxHeartRate);
	String registerByFacebook(String email, String password, String name, String birthdate, String weight, String height, int maxHeartRate);
	String loginByEmail(String email, String password);
	String loginByGoogle(String email, String password);
	String loginByFacebook(String email, String password);
	String logout(String token) throws RemoteException;
}
