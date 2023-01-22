package server.data.domain;

import server.data.enums.ProfileType;

public class Login{
	public final String email;
	public final String password;
	public final ProfileType profileType;
	public Login(String email, String password, ProfileType profileType) {
		super();
		this.email = email;
		this.password = password;
		this.profileType = profileType;
	}
	
}
