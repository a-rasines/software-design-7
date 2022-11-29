package server.factory;

import server.data.CacheDatabase;
import server.data.domain.EmailProfile;
import server.data.dto.LoginDTO;
import server.data.dto.ProfileTypeDTO;

public class EmailVerifier implements AuthInterface{
	private LoginDTO profile;
	public EmailVerifier(LoginDTO profile) {
		if(profile.profileType != ProfileTypeDTO.EMAIL)
			throw new IllegalArgumentException();
	}

	@Override
	public boolean authenticate() {
		return CacheDatabase.userMap.contains(ProfileTypeDTO.EMAIL, profile.email) && ((EmailProfile)CacheDatabase.userMap.get(ProfileTypeDTO.EMAIL, profile.email)).getPassword().equals(profile.password);
	}
}
