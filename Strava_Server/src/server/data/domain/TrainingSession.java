package server.data.domain;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import server.data.abstracts.AbstractTrainingSession;
import server.data.enums.Sport;

public class TrainingSession extends AbstractTrainingSession{

	public TrainingSession(String name, Sport sport, Date startDate, double distance, long duration) {
		super(name, sport, startDate, distance, duration);
		// TODO Auto-generated constructor stub
	}
	
	public TrainingSession(long id, String name, Sport sport, Date startDate, double distance, long duration) {
		super(name, sport, startDate, distance, duration);
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	
}
