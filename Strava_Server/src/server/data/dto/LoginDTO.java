package server.data.dto;

import java.io.Serializable;

import server.data.abstracts.AbstractLogin;
import server.data.enums.ProfileType;

public class LoginDTO extends AbstractLogin implements Serializable {
	public LoginDTO(String email, String password, ProfileType profileType) {
		super(email, password, profileType);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 8349364869312846347L;
	
}
