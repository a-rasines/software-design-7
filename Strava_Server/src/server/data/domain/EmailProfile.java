package server.data.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import server.data.enums.ProfileType;

public class EmailProfile extends Profile {
	protected EmailProfile(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, List<TrainingSession> sessions, HashMap<Challenge,Integer> challenges) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, ProfileType.EMAIL);
	}
	String password;
	public EmailProfile(long id, String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, List<TrainingSession> sessions, HashMap<Challenge,Integer> challenges) {
		super(id, name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, ProfileType.EMAIL);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public boolean equals(Object obj) {
		return obj instanceof EmailProfile && getEmail().equals(((EmailProfile)obj).getEmail());
	}
}
