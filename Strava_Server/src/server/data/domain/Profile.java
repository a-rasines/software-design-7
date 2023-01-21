package server.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import server.data.dao.ChallengeDAO;
import server.data.dao.TrainingSessionDAO;
import server.data.enums.ProfileType;
@PersistenceCapable(detachable="true")
public class Profile{
	public static Profile of(String name, Date birthdate, double weight, double height, double maxHeartRate, double restHeartRate,
			String email, List<TrainingSession> sessions, Map<Challenge, Byte> challenges,
			ProfileType profileType) {
		switch(profileType) {
			case EMAIL:
				return new EmailProfile(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges);
			default:
				return new Profile(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, profileType);
		}
	}
	public static Profile of(long id, String name, Date birthdate, double weight, double height, double maxHeartRate, double restHeartRate,
			String email, List<TrainingSession> sessions, Map<Challenge, Byte> challenges,
			ProfileType profileType) {
		switch(profileType) {
			case EMAIL:
				return new EmailProfile(id, name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges);
			default:
				return new Profile(id, name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, profileType);
		}
	}
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private long id;
	
	protected ProfileType profileType;
	protected String name;
	protected Date birthdate;
	protected double weight;
	protected double height;
	protected double maxHeartRate;
	protected double restHeartRate;
	protected String email;
	
	@Join
	@Persistent(mappedBy="owner", dependentElement="true", defaultFetchGroup="true")
	List<TrainingSession> sessions;
	@Join
	@Persistent(defaultFetchGroup="true")//@Persistent(mappedBy="profile", dependentElement="true", defaultFetchGroup="true")
	Map<Challenge, Byte> challenges;
	
	protected Profile() {}
	
	protected Profile(String name, Date birthdate, double weight, double height, double maxHeartRate, double restHeartRate,
			String email, List<TrainingSession> sessions, Map<Challenge, Byte> challenges, ProfileType profileType) {
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
	protected Profile(Long id, String name, Date birthdate, double weight, double height, double maxHeartRate, double restHeartRate,
			String email, List<TrainingSession> sessions, Map<Challenge, Byte> challenges,
			ProfileType profileType) {
		this.id = id;
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
	
	public long getId() {
		return id;
	}
	public void createTrainingSession(TrainingSession e) {
		this.sessions.add(e);
		new HashMap<Challenge, Byte>(challenges).forEach((k, v)->{
			if(k.getDistanceTarget() != 0) {
				challenges.put(k, (byte) (v + 100*e.getDistance()/k.getDistanceTarget()));
			}else if(k.getTimeTarget() != 0) {
				challenges.put(k, (byte) (v + 100*e.getDuration()/k.getTimeTarget()));
			}
		});
		TrainingSessionDAO.getInstance().save(e);
	}
	public void setupChallenge(Challenge e) {
		ChallengeDAO.getInstance().save(e);
	}
	public boolean acceptChallenge(Challenge e) {
		return this.challenges.putIfAbsent(e, (byte)0) == null;
	}
	public List<Challenge> downloadChallenge() {
		return ChallengeDAO.getInstance().getSomeChallenges();
	}
	public List<Challenge> downloadCompletedChallenges(){
		List<Challenge> res = new ArrayList<>();
		challenges.forEach((k, v) ->{
			if(v >= 100)
				res.add(k);
		});
		return res;
	}
	
	public Map<Challenge, Byte> downloadActiveChallenges(){
		Map<Challenge, Byte> res = new HashMap<>();
		challenges.forEach((k, v) ->{
			if(v < 100)
				res.put(k, v);
		});
		return res;
	}
	public List<TrainingSession> getSessions() {
		return sessions;
	}
	public ProfileType getProfileType() {
		return profileType;
	}
	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}
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
	public double getRestHeartRate() {
		return restHeartRate;
	}
	public void setRestHeartRate(double restHeartRate) {
		this.restHeartRate = restHeartRate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Map<Challenge, Byte> getChallenges() {
		return challenges;
	}
	public void setChallenges(Map<Challenge, Byte> challenges) {
		this.challenges = challenges;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setSessions(List<TrainingSession> sessions) {
		this.sessions = sessions;
	}
}
