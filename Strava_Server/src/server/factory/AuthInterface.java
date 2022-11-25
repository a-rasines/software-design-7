package server.factory;

public interface AuthInterface {
	boolean authenticate(String email, String password);
}
