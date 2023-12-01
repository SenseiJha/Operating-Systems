package Networking_and_Communication;

import java.rmi.RemoteException;

public class Message_Service_Implementation implements Message_Service {

	@Override
	public String getMessage() throws RemoteException {
		return "Hello From Server !!!";
	}
	
}
