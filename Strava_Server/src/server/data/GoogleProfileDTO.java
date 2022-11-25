package server.data;

import java.util.Date;
import java.util.List;

public class GoogleProfileDTO extends ProfileDTO{
	private static final long serialVersionUID = 7433386702263190471L;

	protected GoogleProfileDTO(String name, Date birthdate, double weight, double height, double maxHeartRate,
			double restHeartRate, String email, List<TrainingSessionDTO> sessions, List<ChallengeDTO> challenges) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges);
		// TODO Auto-generated constructor stub
	}

}
