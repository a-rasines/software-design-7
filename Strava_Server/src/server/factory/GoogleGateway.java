package server.factory;

import java.rmi.RemoteException;

import googleConect.GServerController;
import server.data.dto.LoginDTO;
import server.data.dto.ProfileTypeDTO;


public class GoogleGateway implements AuthInterface{
	private LoginDTO profile;
	public GoogleGateway(LoginDTO profile) {
		if(profile.profileType != ProfileTypeDTO.GOOGLE)
			throw new IllegalArgumentException();
		this.profile = profile;
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
