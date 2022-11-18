package server.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EmailProfileDTO extends ProfileDTO implements Serializable {
	protected EmailProfileDTO(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, List<TrainingSessionDTO> sessions, List<ChallengeDTO> challenges, String password) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges);
		this.password = password;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 6426213920166692292L;
	String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
