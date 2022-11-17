package testing;

import server.remote.IServer;

import server.remote.ServiceLocator;

public class ServerHandlerSim extends ServiceLocator{
	String sessionToken;
	IServer service = new ServerSim();
	public IServer getService() {
		return this.service;
	}
}
