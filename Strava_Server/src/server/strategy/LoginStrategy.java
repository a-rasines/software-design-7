package server.strategy;

import server.data.AccountTypeDTO;

public class LoginStrategy {
	
	private static LoginStrategy instance;
	
	public static LoginStrategy getInstance() {
		if(instance == null) {
			instance = new LoginStrategy();
			
		}
		return instance;
	}
	
	private LoginStrategy() {}

	public String login(AccountTypeDTO accountType, String email, String password) {
		switch (accountType) {
		case GOOGLE: 
			return GoogleGateway.authenticate(email, password);
			
		case FACEBOOK:
			//TODO;
			return FacebookAssembler.authenticate(email, password);
		case EMAIL:
			//TODO
			return EmailVerifier.emailLogin(email, password);
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + accountType);
		}
	}
}
