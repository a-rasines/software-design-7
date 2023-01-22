package server.data.domain;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import server.data.enums.Sport;
@PersistenceCapable(detachable="true")
public class TrainingSession {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private long id;
	String name;
	Sport sport;
	Date startDate;	
	double distance;
	long duration;
	
	private Profile owner;
	
	
	
	public TrainingSession(long id, String name, Sport sport, Date startDate, double distance, long duration,
			Profile owner) {
		this.id = id;
		this.name = name;
		this.sport = sport;
		this.startDate = startDate;
		this.distance = distance;
		this.duration = duration;
		this.owner = owner;
	}
	
	public TrainingSession(String name, Sport sport, Date startDate, double distance, long duration,
			Profile owner) {
		this.name = name;
		this.sport = sport;
		this.startDate = startDate;
		this.distance = distance;
		this.duration = duration;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public void setOwner(Profile owner) {
		this.owner = owner;
	}

	public Profile getOwner() {
		return owner;
	}

	public long getId() {
		return id;
	}

	
}
