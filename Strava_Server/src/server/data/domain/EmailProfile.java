package server.data.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jdo.annotations.PersistenceCapable;

import server.data.enums.ProfileType;
@PersistenceCapable(detachable="true")
public class EmailProfile extends Profile {
	protected EmailProfile(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, List<TrainingSession> sessions, Map<Challenge, Byte> challenges) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, ProfileType.EMAIL);
	}
	String password;
	public EmailProfile(long id, String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, List<TrainingSession> sessions, Map<Challenge, Byte> challenges) {
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
