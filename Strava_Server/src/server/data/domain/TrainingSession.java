package server.data.domain;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import server.data.abstracts.AbstractTrainingSession;
import server.data.enums.Sport;
@PersistenceCapable(detachable="true")
public class TrainingSession extends AbstractTrainingSession{

	public TrainingSession(String name, Sport sport, Date startDate, double distance, long duration, Profile owner) {
		super(name, sport, startDate, distance, duration);
		// TODO Auto-generated constructor stub
	}
	
	public TrainingSession(long id, String name, Sport sport, Date startDate, double distance, long duration, Profile owner) {
		super(name, sport, startDate, distance, duration);
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private long id;
	
	private Profile owner;
	
	public Profile getOwner() {
		return owner;
	}

	public long getId() {
		return id;
	}

	
}
