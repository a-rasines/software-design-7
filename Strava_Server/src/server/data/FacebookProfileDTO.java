package server.data;

import java.util.Date;
import java.util.List;

public class FacebookProfileDTO extends ProfileDTO {
	private static final long serialVersionUID = 398667439957249117L;

	protected FacebookProfileDTO(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, List<TrainingSessionDTO> sessions, List<ChallengeDTO> challenges) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges);
		// TODO Auto-generated constructor stub
	}

}
