package server.data;

import java.io.Serializable;
import java.util.Date;

public class ChallengeDTO implements Serializable{
	private static final long serialVersionUID = -3065560988452699384L;
	
	String name;
	Date startDate;
	Date endDate;
	double distanceTarget;
	long timeTarget;
	SportDTO sport;
	
}
