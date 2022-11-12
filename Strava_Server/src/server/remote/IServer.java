package server.remote;

import java.rmi.RemoteException;

public interface IServer {
	//List<Session> activeSessions;
	String registerByEmail(String email, String password);
	String registerByGoogle(String email, String password);
	String registerByFacebook(String email, String password);
	String loginByEmail(String email, String password);
	String loginByGoogle(String email, String password);
	String loginByFacebook(String email, String password);
	String logout(String token) throws RemoteException;
}
