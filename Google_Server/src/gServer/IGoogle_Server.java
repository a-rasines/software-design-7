package gServer;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGoogle_Server extends Remote{
	
	boolean authenticate(String email, String password) throws RemoteException;

}
