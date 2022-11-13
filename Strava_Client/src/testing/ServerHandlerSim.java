package testing;

import server.remote.IServer;
import server.remote.ServerHandler;

public class ServerHandlerSim extends ServerHandler{
	String sessionToken;
	IServer service = new ServerSim();
	public IServer getService() {
		return this.service;
	}
}
