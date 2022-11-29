package server.data.dto;

import java.io.Serializable;
import java.util.Date;

public class ProfileDTO implements Serializable {
	public ProfileDTO(ProfileTypeDTO profileType, String name, Date birthdate, double weight, double height,
			double maxHeartRate, double restHeartRate, String email) {
		super();
		this.profileType = profileType;
		this.name = name;
		this.birthdate = birthdate;
		this.weight = weight;
		this.height = height;
		this.maxHeartRate = maxHeartRate;
		this.restHeartRate = restHeartRate;
		this.email = email;
	}
	private static final long serialVersionUID = 8047537504293008087L;
	ProfileTypeDTO profileType;
	String name;
	Date birthdate;
	double weight;
	double height;
	double maxHeartRate;
	double restHeartRate;
	String email;
	public ProfileTypeDTO getProfileType() {
		return profileType;
	}
	public String getID() {
		return email;
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

}
