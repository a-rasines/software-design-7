package server.remote;

import java.rmi.Naming;

/**
 * Handles the connection with the server.
 */
public class ServiceLocator {
	
	//Da error, pero es normal, se soluciona con el build
	//Remote Facade reference
	private IRemoteFacade service;
	public ServiceLocator() {};
	public ServiceLocator(String ip, String port, String serviceName) {
		setService(ip, port, serviceName);
	}
	public void setService(String ip, String port, String serviceName) {
		//Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		//Get Remote Facade reference using RMIRegistry (IP + Port) and the service name.
		try {		
			String URL = "//" + ip + ":" + port + "/" + serviceName;
			this.service = (IRemoteFacade) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}		
	}

	public IRemoteFacade getService() {
		return this.service;
	}
	
}
