package server.strategy;

import java.rmi.RemoteException;

import googleConect.GServerController;
import googleConect.GServiceLocator;
import server.data.AccountTypeDTO;

public class LoginStrategy {

	public static String login(AccountTypeDTO accountType, String email, String password) {
		switch (accountType) {
		case GOOGLE: 
			GServerController.setServerHandler(new GServiceLocator("127.0.0.1", "1099" , "Google_Server"));
			try {
				return GServerController.authenticate(e​mail, p​assword);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		case FACEBOOK:
			//TODO;
			return FacebookAssembler.authenticate(email, password);
		case EMAIL:
			//TODO
			return System.currentTimeMillis() + "";
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + accountType);
		}
	}
}
