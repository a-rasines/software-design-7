package server.data.dto;

import java.io.Serializable;
import java.util.Date;

public class RegisterDTO implements Serializable{
	private static final long serialVersionUID = -538083309581185155L;
	private String password;
	ProfileTypeDTO profileType;
	String name;
	Date birthdate;
	double weight;
	double height;
	double maxHeartRate;
	double restHeartRate;
	String email;
	public ProfileTypeDTO getType() {
		return profileType;
	}
	public String getName() {
		return name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public double getWeight() {
		return weight;
	}
	public double getHeight() {
		return height;
	}
	public double getMaxHeartRate() {
		return maxHeartRate;
	}
	public double getRestHeartRate() {
		return restHeartRate;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public RegisterDTO(String password, ProfileTypeDTO profileType, String name, Date birthdate, double weight,
			double height, double maxHeartRate, double restHeartRate, String email) {
		super();
		this.password = password;
		this.profileType = profileType;
		this.name = name;
		this.birthdate = birthdate;
		this.weight = weight;
		this.height = height;
		this.maxHeartRate = maxHeartRate;
		this.restHeartRate = restHeartRate;
		this.email = email;
	}
	public LoginDTO toLoginDTO() {
		return new LoginDTO(email, password, profileType);
	}

}
