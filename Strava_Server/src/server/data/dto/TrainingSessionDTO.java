package server.data.dto;

import java.io.Serializable;
import java.util.Date;

public class TrainingSessionDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9206250483986276044L;
	String name;
	SportDTO sport;
	
	Date startDate;
	//Date endDate;
	
	double distance;
	long duration;
}
