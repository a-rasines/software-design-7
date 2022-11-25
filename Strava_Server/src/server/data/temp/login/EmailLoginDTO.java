package server.data.temp.login;

public class EmailLoginDTO implements LoginDTO {
	private static final long serialVersionUID = -6159897131466386219L;
	public final String email;
	public final String password;
	public EmailLoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
}
