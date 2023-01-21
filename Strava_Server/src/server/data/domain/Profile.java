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

import server.data.abstracts.AbstractProfile;
import server.data.dao.ChallengeDAO;
import server.data.dao.TrainingSessionDAO;
import server.data.enums.ProfileType;
@PersistenceCapable(detachable="true")
public class Profile extends AbstractProfile{
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
	@Join
	@Persistent(mappedBy="profile", dependentElement="true", defaultFetchGroup="true")
	List<TrainingSession> sessions;
	@Join
	@Persistent(mappedBy="profile", dependentElement="true", defaultFetchGroup="true")
	Map<Challenge, Byte> challenges;
	protected Profile(String name, Date birthdate, double weight, double height, double maxHeartRate, double restHeartRate,
			String email, List<TrainingSession> sessions, Map<Challenge, Byte> challenges,
			ProfileType profileType) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, profileType);
		this.sessions = sessions;
		this.challenges = challenges;
	}
	protected Profile(Long id, String name, Date birthdate, double weight, double height, double maxHeartRate, double restHeartRate,
			String email, List<TrainingSession> sessions, Map<Challenge, Byte> challenges,
			ProfileType profileType) {
		super(name, birthdate, weight, height, maxHeartRate, restHeartRate, email, sessions, challenges, profileType);
		this.id = id;
		this.sessions = sessions;
		this.challenges = challenges;
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
}
