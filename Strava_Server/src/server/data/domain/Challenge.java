package server.data.domain;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import server.data.abstracts.AbstractChallenge;
import server.data.enums.Sport;
@PersistenceCapable(detachable="true")
public class Challenge extends AbstractChallenge{

	public Challenge(String name, Date startDate, Date endDate, double distanceTarget, long timeTarget, Sport sport) {
		super(name, startDate, endDate, distanceTarget, timeTarget, sport);
		
	}
	
	public Challenge(long id, String name, Date startDate, Date endDate, double distanceTarget, long timeTarget, Sport sport) {
		super(id, name, startDate, endDate, distanceTarget, timeTarget, sport);		
	}


	
}
