package server.strategy;

import server.data.AccountTypeDTO;

public class LoginStrategy {

	public static String login(AccountTypeDTO accountType, String email, String password) {
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
