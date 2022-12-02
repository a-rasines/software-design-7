package server.data.abstracts;

import server.data.enums.ProfileType;

public abstract class AbstractLogin {
	public final String email;
	public final String password;
	public final ProfileType profileType;
	protected AbstractLogin(String email, String password, ProfileType profileType) {
		super();
		this.profileType = profileType;
		this.email = email;
		this.password = password;
	}
	public String getID() {
		return email;
	}
}
