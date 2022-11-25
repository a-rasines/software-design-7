package server.data.temp.register;

import java.util.ArrayList;
import java.util.Date;
import server.data.FacebookProfileDTO;
import server.data.temp.login.FacebookLoginDTO;
import server.data.temp.login.LoginDTO;

public class FacebookRegisterDTO extends FacebookProfileDTO implements RegisterDTO {
	private static final long serialVersionUID = -538083309581185155L;
	private String password;
	public String getPassword() {
		return password;
	}
	public FacebookRegisterDTO(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, String password) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, new ArrayList<>(), new ArrayList<>());
		this.password = password;
	}
	@Override
	public LoginDTO getLoginData() {
		return new FacebookLoginDTO(getEmail(), password);
	}

}
