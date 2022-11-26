package server.data.temp.login;

import server.data.FacebookProfileDTO;
import server.data.ProfileDTO;

public class FacebookLoginDTO implements LoginDTO {
	private static final long serialVersionUID = 4998285652743755327L;
	public final String email;
	public final String password;
	public FacebookLoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	@Override
	public String getID() {
		return email;
	}
	@Override
	public Class<? extends ProfileDTO> getReferredProfileType() {
		return FacebookProfileDTO.class;
	}

}
