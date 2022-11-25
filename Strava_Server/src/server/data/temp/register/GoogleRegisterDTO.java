package server.data.temp.register;

import java.util.ArrayList;
import java.util.Date;
import server.data.GoogleProfileDTO;
import server.data.ProfileDTO;
import server.data.temp.login.GoogleLoginDTO;
import server.data.temp.login.LoginDTO;

public class GoogleRegisterDTO extends GoogleProfileDTO implements RegisterDTO {
	private static final long serialVersionUID = -538083309581185155L;
	private String password;
	public String getPassword() {
		return password;
	}
	public GoogleRegisterDTO(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, String password) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, new ArrayList<>(), new ArrayList<>());
		this.password = password;
	}
	@Override
	public LoginDTO getLoginData() {
		return new GoogleLoginDTO(getEmail(), password);
	}
	@Override
	public ProfileDTO getProfile() {
		return new GoogleProfileDTO(getName(), getBirthdate(), getWeight(), getHeight(), getMaxHeartRate(), getRestHeartRate(), getEmail(), getSessions(), getChallenges());
	}

}
