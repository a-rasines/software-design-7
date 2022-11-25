package server.factory;

import server.data.CacheDatabase;
import server.data.EmailProfileDTO;
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
		return CacheDatabase.userMap.contains(EmailProfileDTO.class, profile.email) && CacheDatabase.userMap.get(EmailProfileDTO.class, profile.email).getPassword().equals(profile.password);
	}
}
