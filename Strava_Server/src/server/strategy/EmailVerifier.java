package server.strategy;

import server.data.ProfileDTO;

public class EmailVerifier {

	public static String emailLogin(String email, String password) {
		return System.currentTimeMillis() + "";
	}
	
	public static String emailRegister(ProfileDTO email, String password) {
		//TODO que haga cosas
		return System.currentTimeMillis() + "";
	}
}
