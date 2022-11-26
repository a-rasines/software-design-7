package server.data.temp.login;

import server.data.EmailProfileDTO;
import server.data.ProfileDTO;

public class EmailLoginDTO implements LoginDTO {
	private static final long serialVersionUID = -6159897131466386219L;
	public final String email;
	public final String password;
	public EmailLoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public EmailLoginDTO(String email, String password, boolean isRegister) {
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
		return EmailProfileDTO.class;
	}
}
