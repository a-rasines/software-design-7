package testing;

import client.remote.IServer;
import client.remote.ServerHandler;

public class ServerHandlerSim extends ServerHandler{
	String sessionToken;
	IServer service = new ServerSim();
	public IServer getService() {
		return this.service;
	}
}
