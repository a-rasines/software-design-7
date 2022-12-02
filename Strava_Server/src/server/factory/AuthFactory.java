package server.factory;

import server.data.domain.Login;

public class AuthFactory {
	
	private AuthFactory() {}
	public static AuthInterface createGateway(Login profile) {

		switch (profile.profileType) {
			case GOOGLE:
				return new GoogleGateway(profile);
			case FACEBOOK:
				return new FacebookGateway(profile);
			default:
				throw new IllegalArgumentException("Unexpected value: " + profile.getClass().getSimpleName());
		}
			
	}
}
