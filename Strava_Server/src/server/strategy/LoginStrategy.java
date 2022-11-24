package server.strategy;

import java.rmi.RemoteException;

import server.data.AccountTypeDTO;

public class LoginStrategy {
	
	private static final LoginStrategy INSTANCE = new LoginStrategy();
	
	public static LoginStrategy getInstance() {
		return INSTANCE;
	}
	
	private LoginStrategy() {}

	public String login(AccountTypeDTO accountType, String email, String password) throws RemoteException{
		boolean verified;
		switch (accountType) {
		case GOOGLE: 
			verified =  GoogleGateway.authenticate(email, password);
			break;
			
		case FACEBOOK:
			//TODO;
			verified =  FacebookAssembler.authenticate(email, password);
			break;
		case EMAIL:
			//TODO
			verified = EmailVerifier.emailLogin(email, password);
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + accountType);
		}
		if(verified) {
			return System.currentTimeMillis() +"";
		}
		 throw new RemoteException();
	}
}
