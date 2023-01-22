package server.data.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import server.data.enums.Sport;
@PersistenceCapable(detachable="true")
public class Challenge{
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private long id;
	
	String name;
	long startDate;
	long endDate;
	double distanceTarget;
	long timeTarget;
	Sport sport;
	
	public Challenge(long id, String name, long startDate, long endDate, double distanceTarget, long timeTarget,
			Sport sport) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.distanceTarget = distanceTarget;
		this.timeTarget = timeTarget;
		this.sport = sport;
	}
	
	public Challenge(String name, long startDate, long endDate, double distanceTarget, long timeTarget,
			Sport sport) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.distanceTarget = distanceTarget;
		this.timeTarget = timeTarget;
		this.sport = sport;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
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
