package server.factory;

import java.rmi.RemoteException;

import googleConect.GServerController;
import server.data.temp.login.GoogleLoginDTO;
import server.data.temp.login.LoginDTO;


public class GoogleGateway implements AuthInterface{
	private GoogleLoginDTO profile;
	public GoogleGateway(LoginDTO profile2) {
		if((profile2 instanceof GoogleLoginDTO))
			throw new IllegalArgumentException();
		this.profile = (GoogleLoginDTO) profile2;
	}
	public boolean authenticate() {
		
		try {
			return GServerController.authenticate(profile.email, profile.password);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.err.println("Error authenticating");
			return false;
		}
		
	}
}
