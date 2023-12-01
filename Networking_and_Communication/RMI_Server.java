package Networking_and_Communication;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI_Server {
	public static void main(String[] args) {
		try {
			Message_Service message = new Message_Service_Implementation();
			Registry register = LocateRegistry.createRegistry(1099);
			register.bind("Message Service", message);
			System.out.println("Server is running...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
