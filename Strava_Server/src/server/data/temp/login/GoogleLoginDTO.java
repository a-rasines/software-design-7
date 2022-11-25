package server.data.temp.login;

public class GoogleLoginDTO implements LoginDTO{
	private static final long serialVersionUID = 2190252303732591508L;
	public final String email;
	public final String password;
	public GoogleLoginDTO(String email, String password) {
		this.password = password;
		this.email = email;
	}

}
