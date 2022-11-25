package server.factory;

import server.data.EmailProfileDTO;
import server.data.temp.AuthDTO;
import server.data.temp.login.FacebookLoginDTO;
import server.data.temp.login.GoogleLoginDTO;
import server.data.temp.login.LoginDTO;
import server.data.temp.register.RegisterDTO;

public class AuthFactory {
	
	public AuthInterface getInstance(AuthDTO profile) {
		LoginDTO login;
		if(profile instanceof RegisterDTO)
			login = ((RegisterDTO)profile).getLoginData();
		else login = ((LoginDTO) profile);
		if(profile instanceof GoogleLoginDTO)
			return new GoogleGateway(login);
		else if(profile instanceof FacebookLoginDTO)
			return new FacebookAssembler(login);
		else if(profile instanceof EmailProfileDTO)
			return new EmailVerifier(login);
		else
			throw new IllegalArgumentException("Unexpected value: " + profile.getClass().getSimpleName());
	}
}
