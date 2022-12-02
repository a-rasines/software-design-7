package server.data.domain;

import java.util.Date;
import java.util.List;

import server.data.dto.ChallengeDTO;
import server.data.dto.ProfileTypeDTO;
import server.data.dto.TrainingSessionDTO;

public class EmailProfile extends Profile {
	protected EmailProfile(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, List<TrainingSessionDTO> sessions, List<ChallengeDTO> challenges) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, ProfileTypeDTO.EMAIL);
	}
	String password;
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