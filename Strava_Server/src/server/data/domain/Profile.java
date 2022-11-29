package server.data.domain;

import java.util.Date;
import java.util.List;

import server.data.dto.ChallengeDTO;
import server.data.dto.ProfileTypeDTO;
import server.data.dto.TrainingSessionDTO;

public class Profile {
	public Profile(String name, Date birthdate, double weight, double height, double maxHeartRate, double restHeartRate,
			String email, List<TrainingSessionDTO> sessions, List<ChallengeDTO> challenges, ProfileTypeDTO profileType) {
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
		this.profileType = profileType;
	}
	ProfileTypeDTO profileType;
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
	public ProfileTypeDTO getType() {
		return profileType;
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
