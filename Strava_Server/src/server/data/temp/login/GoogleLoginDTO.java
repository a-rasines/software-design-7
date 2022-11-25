package server.data.temp.login;

import server.data.GoogleProfileDTO;
import server.data.ProfileDTO;

public class GoogleLoginDTO implements LoginDTO{
	private static final long serialVersionUID = 2190252303732591508L;
	public final String email;
	public final String password;
	public GoogleLoginDTO(String email, String password) {
		this.password = password;
		this.email = email;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Class<? extends ProfileDTO> getReferredProfile() {
		return GoogleProfileDTO.class;
	}

}
