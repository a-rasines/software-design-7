package server.data.temp.register;

import java.util.ArrayList;
import java.util.Date;
import server.data.GoogleProfileDTO;
import server.data.ProfileDTO;
import server.data.temp.login.GoogleLoginDTO;
import server.data.temp.login.LoginDTO;

public class GoogleRegisterDTO implements RegisterDTO {
	private static final long serialVersionUID = -538083309581185155L;
	private String password;
	public String getPassword() {
		return password;
	}
	private GoogleProfileDTO profile;
	public GoogleRegisterDTO(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, String password) {
		profile = new GoogleProfileDTO(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, new ArrayList<>(), new ArrayList<>());
		this.password = password;
	}
	@Override
	public LoginDTO getLoginData() {
		return new GoogleLoginDTO(profile.getEmail(), password);
	}
	@Override
	public ProfileDTO getProfile() {
		return profile;
	}

}
