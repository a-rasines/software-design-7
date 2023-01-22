package server.data.dto;

import java.io.Serializable;
import java.util.Date;

import server.data.enums.Sport;

public class TrainingSessionDTO implements Serializable {
	private static final long serialVersionUID = 9206250483986276044L;
	
	private long id;
	String name;
	Sport sport;
	Date startDate;	
	double distance;
	long duration;
	
	public TrainingSessionDTO(long id, String name, Sport sport, Date startDate, double distance, long duration) {
		this.id = id;
		this.name = name;
		this.sport = sport;
		this.startDate = startDate;
		this.distance = distance;
		this.duration = duration;
	}
	
	public TrainingSessionDTO(String name, Sport sport, Date startDate, double distance, long duration) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}
	
	
	
	
	
}
