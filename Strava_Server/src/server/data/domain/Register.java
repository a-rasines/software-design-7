package server.data.domain;

import java.util.Date;

import server.data.enums.ProfileType;

public class Register {
	private String password;
	ProfileType profileType;
	String name;
	Date birthdate;
	double weight;
	double height;
	double maxHeartRate;
	double restHeartRate;
	String email;
	public ProfileType getType() {
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
	public Register(String password, ProfileType profileType, String name, Date birthdate, double weight,
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
}
