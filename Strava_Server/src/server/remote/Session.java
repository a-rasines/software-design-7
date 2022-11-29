package server.remote;


import server.data.domain.Profile;

public class Session {
	public Session(Profile user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	public final Profile user;
	public final String token;
}
