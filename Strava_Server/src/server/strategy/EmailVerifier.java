package server.strategy;

import server.data.ProfileDTO;

public class EmailVerifier {

	public static boolean emailLogin(String email, String password) {
		return true;
	}
	
	public static boolean emailRegister(ProfileDTO email, String password) {
		//TODO que b cosas
		return true;
	}
}
