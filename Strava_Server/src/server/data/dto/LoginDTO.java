package server.data.dto;

import java.io.Serializable;

import server.data.enums.ProfileType;

public class LoginDTO implements Serializable {
	public final String email;
	public final String password;
	public final ProfileType profileType;

	public LoginDTO(String email, String password, ProfileType profileType) {
		this.email = email;
		this.password = password;
		this.profileType = profileType;
	}

	private static final long serialVersionUID = 8349364869312846347L;
	
}
