package server.data.temp.register;

import java.util.ArrayList;
import java.util.Date;
import server.data.EmailProfileDTO;
import server.data.ProfileDTO;
import server.data.temp.login.EmailLoginDTO;
import server.data.temp.login.LoginDTO;

public class EmailRegisterDTO implements RegisterDTO{

	private static final long serialVersionUID = -6327797775551415061L;
	private final EmailProfileDTO profile;
	public EmailRegisterDTO(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, String password) {
		profile = new EmailProfileDTO(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, new ArrayList<>(), new ArrayList<>(), password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LoginDTO getLoginData() {
		return new EmailLoginDTO(profile.getEmail(), profile.getPassword(), true);
	}

	@Override
	public ProfileDTO getProfile() {
		return profile;
	}

}
