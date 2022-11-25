package server.factory;

import server.data.temp.login.EmailLoginDTO;
import server.data.temp.login.LoginDTO;

public class EmailVerifier implements AuthInterface{
	private EmailLoginDTO profile;
	public EmailVerifier(LoginDTO profile) {
		if(!(profile instanceof EmailLoginDTO))
			throw new IllegalArgumentException();
		this.profile = (EmailLoginDTO) profile;
	}

	@Override
	public boolean authenticate() {
		return true;
	}
}
