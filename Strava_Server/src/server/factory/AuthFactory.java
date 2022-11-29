package server.factory;

import server.data.dto.LoginDTO;

public class AuthFactory {
	
	private AuthFactory() {}
	public static AuthInterface createGateway(LoginDTO profile) {

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
