package server.data;

import java.util.Date;

import server.data.dto.SportDTO;

public class AbstractTrainingSession {
	String name;
	SportDTO sport;
	
	Date startDate;
	//Date endDate;
	
	double distance;
	long duration;
}
