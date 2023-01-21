package server.factory;

import server.data.dao.EmailProfileDAO;
import server.data.domain.EmailProfile;
import server.data.domain.Login;
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
		EmailProfile p = EmailProfileDAO.getInstance().find(profile.email);
		return p.getPassword().equals(profile.password);
	}
}
