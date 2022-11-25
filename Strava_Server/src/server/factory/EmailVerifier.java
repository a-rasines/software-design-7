package server.factory;



public class EmailVerifier implements AuthInterface{

	public boolean authenticate(String email, String password) {
		return true;
	}
}
