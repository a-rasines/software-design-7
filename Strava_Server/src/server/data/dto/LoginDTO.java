package server.data.dto;

public class LoginDTO {
	public final String email;
	public final String password;
	public final ProfileTypeDTO profileType;
	public LoginDTO(String email, String password, ProfileTypeDTO profileType) {
		super();
		this.profileType = profileType;
		this.email = email;
		this.password = password;
	}
	public String getID() {
		return email;
	}
}
