package Networking_and_Communication;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI_Client {
	public static void main(String[] args) {
		try {
			Registry register = LocateRegistry.getRegistry("localhost", 1099);
			Message_Service message = (Message_Service) register.lookup("Message Service");
			System.out.println("Message from server : " + message.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
