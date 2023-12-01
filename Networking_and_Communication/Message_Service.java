package Networking_and_Communication;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Message_Service extends Remote {
	public String getMessage() throws RemoteException;
}
