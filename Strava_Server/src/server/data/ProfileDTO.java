package server.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProfileDTO implements Serializable {
	private static final long serialVersionUID = -3413613342993346997L;
	public static class Builder{
		String name;
		String password;
		Date birthdate;
		double weight = 0;
		double height = 0;
		double maxHeartRate = 0;
		double restHeartRate = 0;
		String email;
		List<TrainingSessionDTO> sessions = new ArrayList<>();
		List<ChallengeDTO> challenges = new ArrayList<>();
		AccountTypeDTO type;
		public Builder(AccountTypeDTO type, String name, Date birthdate, String email) {
			this.type = type;
			this.name = name;
			this.birthdate = birthdate;
			this.email = email;
		}
		public Builder weight(double weight) {
			this.weight = weight;
			return this;
		}
		public Builder height(double weight) {
			this.weight = weight;
			return this;
		}
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		public Builder maxHeartRate(double mhr) {
			this.maxHeartRate = mhr;
			return this;
		}
		public Builder restHeartRate(double rhr) {
			this.restHeartRate = rhr;
			return this;
		}
		public Builder sessions(TrainingSessionDTO... sessions) {
			this.sessions = Arrays.asList(sessions);
			return this;
		}
		public Builder sessions(List<TrainingSessionDTO> sessions) {
			this.sessions = sessions;
			return this;
		}
		public Builder challenges(ChallengeDTO... challenges) {
			this.challenges = Arrays.asList(challenges);
			return this;
		}
		public Builder challenges(List<ChallengeDTO> challenges) {
			this.challenges = challenges;
			return this;
		}
		public ProfileDTO build() {
			if(type == AccountTypeDTO.EMAIL)
				return new EmailProfileDTO(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, password);
			else
				return new ProfileDTO(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges);
		}
		
	}
	protected ProfileDTO(String name, Date birthdate, double weight, double height, double maxHeartRate, double restHeartRate,
			String email, List<TrainingSessionDTO> sessions, List<ChallengeDTO> challenges) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.weight = weight;
		this.height = height;
		this.maxHeartRate = maxHeartRate;
		this.restHeartRate = restHeartRate;
		this.email = email;
		this.sessions = sessions;
		this.challenges = challenges;
	}
	String name;
	Date birthdate;
	double weight;
	double height;
	double maxHeartRate;
	double restHeartRate;
	String email;
	List<TrainingSessionDTO> sessions;
	List<ChallengeDTO> challenges;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getMaxHeartRate() {
		return maxHeartRate;
	}
	public void setMaxHeartRate(double maxHeartRate) {
		this.maxHeartRate = maxHeartRate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<TrainingSessionDTO> getSessions() {
		return sessions;
	}
	public void setSessions(List<TrainingSessionDTO> sessions) {
		this.sessions = sessions;
	}
	public List<ChallengeDTO> getChallenges() {
		return challenges;
	}
	public void setChallenges(List<ChallengeDTO> challenges) {
		this.challenges = challenges;
	}
	public double getRestHeartRate() {
		return restHeartRate;
	}
	public void setRestHeartRate(double restHeartRate) {
		this.restHeartRate = restHeartRate;
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
