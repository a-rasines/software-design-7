package server.data.abstracts;

import java.util.Date;

import server.data.enums.Sport;

public class AbstractTrainingSession {
	String name;
	
	public AbstractTrainingSession(String name, Sport sport, Date startDate, double distance, long duration) {
		super();
		this.name = name;
		this.sport = sport;
		this.startDate = startDate;
		this.distance = distance;
		this.duration = duration;
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
	Sport sport;
	
	Date startDate;
	//Date endDate;
	
	double distance;
	long duration;
}
