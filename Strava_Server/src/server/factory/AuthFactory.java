package server.factory;

import java.rmi.RemoteException;

import server.data.AccountTypeDTO;
import server.data.ProfileDTO;

public class AuthFactory {
	
	public static String googleLogin(String email, String password) throws RemoteException{
		if(GoogleGateway.authenticate(email, password)) {
			return System.currentTimeMillis() + "";
		}
		throw new RemoteException();
	}
	public static String facebookLogin(String email, String password) throws RemoteException{
		if(FacebookAssembler.authenticate(email, password)) {
			return System.currentTimeMillis() + "";
		}
		throw new RemoteException();
	}
	public static String emailLogin(String email, String password) throws RemoteException{
		if(EmailVerifier.emailLogin(email, password)) {
			return System.currentTimeMillis() + "";
		}
		throw new RemoteException();
	}
	
	public static String googleRegister(ProfileDTO pdto, String password) throws RemoteException {
		if(GoogleGateway.authenticate(pdto.getEmail(), password)) {
			return System.currentTimeMillis() + "";
		}
		throw new RemoteException();
	}
	public static String facebookRegister(ProfileDTO pdto, String password) throws RemoteException {
		if(FacebookAssembler.authenticate(pdto.getEmail(), password)) {
			return System.currentTimeMillis() + "";
		}
		throw new RemoteException();
	}
	public static String emailRegister(ProfileDTO pdto, String password) throws RemoteException {
		if(EmailVerifier.emailRegister(pdto, password)) {
			return System.currentTimeMillis() + "";
		}
		throw new RemoteException();
	}
}
