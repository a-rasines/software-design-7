package server.factory;

import server.data.CacheDatabase;
import server.data.domain.EmailProfile;
import server.data.domain.Login;
import server.data.dto.LoginDTO;
import server.data.enums.ProfileType;

public class EmailVerifier implements AuthInterface{
	private Login profile;
	public EmailVerifier(Login profile) {
		if(profile.profileType != ProfileType.EMAIL)
			throw new IllegalArgumentException();
		this.profile = profile;
	}

	@Override
	public boolean authenticate() {
		return CacheDatabase.userMap.contains(ProfileType.EMAIL, profile.email) && ((EmailProfile)CacheDatabase.userMap.get(ProfileType.EMAIL, profile.email)).getPassword().equals(profile.password);
	}
}
