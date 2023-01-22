package server.data.abstracts;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import server.data.enums.Sport;

@PersistenceCapable
public abstract class AbstractChallenge {
	
	public AbstractChallenge(String name, Date startDate, Date endDate, double distanceTarget, long timeTarget,
			Sport sport) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.distanceTarget = distanceTarget;
		this.timeTarget = timeTarget;
		this.sport = sport;
	}
	public AbstractChallenge(long id, String name, Date startDate, Date endDate, double distanceTarget, long timeTarget,
			Sport sport) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.distanceTarget = distanceTarget;
		this.timeTarget = timeTarget;
		this.sport = sport;
	}
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private long id;
	String name;
	Date startDate;
	Date endDate;
	double distanceTarget;
	long timeTarget;
	Sport sport;
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getDistanceTarget() {
		return distanceTarget;
	}
	public void setDistanceTarget(double distanceTarget) {
		this.distanceTarget = distanceTarget;
	}
	public long getTimeTarget() {
		return timeTarget;
	}
	public void setTimeTarget(long timeTarget) {
		this.timeTarget = timeTarget;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
}
