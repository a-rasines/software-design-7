package server.factory;

import java.rmi.Naming;
import java.rmi.RemoteException;

import gServer.IGoogle_Server;

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
			return service.authenticate(profile.email, profile.password);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.err.println("Error authenticating");
			return false;
		}
		
	}
	
	private static IGoogle_Server service;
	public static void setService(String ip, String port, String serviceName) {
		//Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		//Get Remote Facade reference using RMIRegistry (IP + Port) and the service name.
		try {		
			String URL = "//" + ip + ":" + port + "/" + serviceName;
			service = (IGoogle_Server) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}		
	}

	
}
