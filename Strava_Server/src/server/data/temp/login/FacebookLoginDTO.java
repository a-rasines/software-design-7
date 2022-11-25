package server.data.temp.login;

public class FacebookLoginDTO implements LoginDTO {
	private static final long serialVersionUID = 4998285652743755327L;
	public final String email;
	public final String password;
	public FacebookLoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

}
