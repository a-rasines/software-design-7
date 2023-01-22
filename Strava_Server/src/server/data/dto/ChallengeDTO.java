package server.data.dto;

import java.io.Serializable;
import java.util.Date;

import server.data.enums.Sport;

public class ChallengeDTO implements Serializable{
	private static final long serialVersionUID = -3065560988452699384L;
	
	private long id;
	String name;
	Date startDate;
	Date endDate;
	double distanceTarget;
	long timeTarget;
	Sport sport;
	public final byte progress;
	
	public ChallengeDTO(long id, String name, Date startDate, Date endDate, double distanceTarget, long timeTarget,
			Sport sport, byte progress) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.distanceTarget = distanceTarget;
		this.timeTarget = timeTarget;
		this.sport = sport;
		this.progress = progress;
	}
	
	public ChallengeDTO(String name, Date startDate, Date endDate, double distanceTarget, long timeTarget,
			Sport sport, byte progress) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.distanceTarget = distanceTarget;
		this.timeTarget = timeTarget;
		this.sport = sport;
		this.progress = progress;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
