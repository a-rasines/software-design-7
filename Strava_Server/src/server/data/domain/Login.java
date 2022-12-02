package server.data.domain;

import server.data.abstracts.AbstractLogin;
import server.data.enums.ProfileType;

public class Login extends AbstractLogin{

	protected Login(String email, String password, ProfileType profileType) {
		super(email, password, profileType);
	}
}
