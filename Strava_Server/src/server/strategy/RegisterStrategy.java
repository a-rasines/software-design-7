package server.strategy;

import server.data.AccountTypeDTO;
import server.data.ProfileDTO;

public class RegisterStrategy {

	public static String register(AccountTypeDTO accountType, ProfileDTO profile, String password) {
		String token;
		switch (accountType) {
		case GOOGLE: 
			//Checks if the account exists, if so, creates the new user
			token = GoogleGateway.authenticate(profile.getEmail(), password);
			if(token != "0") {
				return token;
			}
			return "0";
			
			
		case FACEBOOK:
			//TODO;
			//Checks if the account exists, if so, creates the new user
			token = FacebookAssembler.authenticate(profile.getEmail(), password);
			if(token != "0") {
				return token;
			}
			return "0";
		case EMAIL:
			//TODO
			//Registers, if it fails, it doesn't
			token = EmailVerifier.emailRegister(profile, password);
			if(token != "0") {
				return token;
			}
			return "0";
			
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + accountType);
		}
	}
}
