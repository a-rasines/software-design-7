package server.data.temp.register;

import java.util.ArrayList;
import java.util.Date;
import server.data.EmailProfileDTO;
import server.data.ProfileDTO;
import server.data.temp.login.EmailLoginDTO;
import server.data.temp.login.LoginDTO;

public class EmailRegisterDTO extends EmailProfileDTO implements RegisterDTO{

	private static final long serialVersionUID = -6327797775551415061L;

	public EmailRegisterDTO(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, String password) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, new ArrayList<>(), new ArrayList<>(), password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LoginDTO getLoginData() {
		return new EmailLoginDTO(getEmail(), getPassword(), true);
	}

	@Override
	public ProfileDTO getProfile() {
		return new EmailProfileDTO(getName(), getBirthdate(), getWeight(), getHeight(), getMaxHeartRate(), getRestHeartRate(), getEmail(), getSessions(), getChallenges(), getPassword());
	}

}
