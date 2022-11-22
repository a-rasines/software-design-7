package googleConect;

import java.rmi.Naming;


public class GServiceLocator {
	private IGoogle_Server service;
	public GServiceLocator() {};
	public GServiceLocator(String ip, String port, String serviceName) {
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
			this.service = (IGoogle_Server) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}		
	}

	public IGoogle_Server getService() {
		return this.service;
	}
}
