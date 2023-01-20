package server.data.dto;

import java.io.Serializable;
import java.util.Date;

import server.data.abstracts.AbstractTrainingSession;
import server.data.enums.Sport;

public class TrainingSessionDTO extends AbstractTrainingSession implements Serializable {
	public TrainingSessionDTO(String name, Sport sport, Date startDate, double distance, long duration) {
		super(name, sport, startDate, distance, duration);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9206250483986276044L;
	
}
