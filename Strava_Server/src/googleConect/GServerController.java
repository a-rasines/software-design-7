package googleConect;

import java.rmi.RemoteException;
import java.lang.String;

public class GServerController {
	public static void setServerHandler(GServiceLocator sv) {
		handler = sv;
	}
	private static GServiceLocator handler;
	
	public static String authenticate(String email, String password) throws RemoteException {
		return handler.getService().authenticate(email, password);
	}
}
