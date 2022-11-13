package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
	//List<Session> activeSessions;
	String registerByEmail(String email, String password, String name, String birthdate, float weight, float height, float maxHeartRate, float restHeartRate) throws RemoteException;
	String registerByGoogle(String email, String password, String name, String birthdate, float weight, float height, float maxHeartRate, float restHeartRate) throws RemoteException;
	String registerByFacebook(String string, String string2, String string3, String string4, float parseFloat, float parseFloat2, float parseFloat3, float parseFloat4) throws RemoteException;
	String loginByEmail(String email, String password) throws RemoteException;
	String loginByGoogle(String email, String password) throws RemoteException;
	String loginByFacebook(String email, String password) throws RemoteException;
	String logout(String token) throws RemoteException;
}