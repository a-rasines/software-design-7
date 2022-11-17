package server.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProfileDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3413613342993346997L;
	String name;
	Date birthdate;
	double weight;
	double height;
	int maxHeartRate;
	String email;
	List<TrainingSessionDTO> sessions;
	List<ChallengeDTO> challenges;
	
	void createTrainingSession() {
		
	}
	void setupChallenge() {
		
	}
	void acceptChallenge() {
		
	}
	void downloadChallenge() {
		
	}
}
