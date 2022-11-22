package server.strategy;

import googleConect.GServerController;
import googleConect.GServiceLocator;
import server.data.AccountTypeDTO;

public class LoginStrategy {

	public static String login(AccountTypeDTO accountType, String email, String password) {
		switch (accountType) {
		case AccountTypeDTO.GOOGLE: 
			GServerController.setServerHandler(new GServiceLocator("127.0.0.1", "1099" , "Google_Server"));
			return GServerController.authenticate(email, password);
			//TODO register
			break;
			
		case AccountTypeDTO.FACEBOOK:
			//TODO;
			return FacebookAssembler.authenticate(email, password);
			break; 
		case AccountTypeDTO.EMAIL:
			//TODO
			return System.currentTimeMillis() + "";
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + accountType);
		}
	}
}
