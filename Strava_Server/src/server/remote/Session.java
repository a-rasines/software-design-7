package server.remote;


import server.data.ProfileDTO;

public class Session {
	public Session(ProfileDTO user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	ProfileDTO user;
	String token;
}
