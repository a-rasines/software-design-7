package server.data.domain;

import java.util.Date;
import java.util.List;

import server.data.abstracts.AbstractProfile;
import server.data.enums.ProfileType;

public class Profile extends AbstractProfile{
	
	public static Profile of(String name, Date birthdate, double weight, double height, double maxHeartRate, double restHeartRate,
			String email, List<TrainingSession> sessions, List<Challenge> challenges,
			ProfileType profileType) {
		switch(profileType) {
			case EMAIL:
				return new EmailProfile(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges);
			default:
				return new Profile(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, profileType);
		}
	}
	protected Profile(String name, Date birthdate, double weight, double height, double maxHeartRate, double restHeartRate,
			String email, List<TrainingSession> sessions, List<Challenge> challenges,
			ProfileType profileType) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, profileType);
		// TODO Auto-generated constructor stub
	}
	void createTrainingSession() {
		
	}
	void setupChallenge() {
		
	}
	void acceptChallenge() {
		
	}
	void downloadChallenge() {
		
	}
}
