package server.data.dto;

import java.io.Serializable;
import java.util.Date;

import server.data.abstracts.AbstractChallenge;
import server.data.enums.Sport;

public class ChallengeDTO extends AbstractChallenge implements Serializable{
	private static final long serialVersionUID = -3065560988452699384L;
	public final byte progress;
	public ChallengeDTO(String name, Date startDate, Date endDate, double distanceTarget, long timeTarget,
			Sport sport, byte progress) {
		super(name, startDate, endDate, distanceTarget, timeTarget, sport);
		this.progress = progress;
	}
	
	
	
}
