package server.data.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import server.data.abstracts.AbstractProfile;
import server.data.enums.ProfileType;

public class ProfileDTO extends AbstractProfile implements Serializable {

	private static final long serialVersionUID = 9189772899204842824L;

	protected ProfileDTO(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, List<TrainingSessionDTO> sessions, List<ChallengeDTO> challenges,
			ProfileType profileType) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, profileType);
	}

}
