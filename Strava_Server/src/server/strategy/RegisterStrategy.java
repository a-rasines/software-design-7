package server.strategy;

import java.rmi.RemoteException;

import server.data.AccountTypeDTO;
import server.data.ProfileDTO;

public class RegisterStrategy {

	private static final RegisterStrategy INSTANCE = new RegisterStrategy();
	
	public static RegisterStrategy getInstance() {
		
		return INSTANCE;
	}
	
	public String register(AccountTypeDTO accountType, ProfileDTO profile, String password) throws RemoteException {
		
		
		
		boolean verified;
		switch (accountType) {
		case GOOGLE: 
			//Checks if the account exists, if so, creates the new user
			verified = GoogleGateway.authenticate(profile.getEmail(), password);
			break;
			
			
		case FACEBOOK:
			//TODO;
			//Checks if the account exists, if so, creates the new user
			verified = FacebookAssembler.authenticate(profile.getEmail(), password);
			break;
		case EMAIL:
			//TODO
			//Registers, if it fails, it doesn't
			verified = EmailVerifier.emailRegister(profile, password);
			
			
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + accountType);
		}
		
		if(verified) {
			return System.currentTimeMillis() + "";
		}
		throw new RemoteException();
	}
}
