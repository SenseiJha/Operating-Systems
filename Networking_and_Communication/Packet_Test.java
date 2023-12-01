package Networking_and_Communication;

import java.util.Scanner;

public class Packet_Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of devices : ");
		int n = sc.nextInt();
		
		Network_For_Devices network = new Network_For_Devices();
		for(int i = 1; i <= n;i++) {
			System.out.println("Enter the device name : ");
			String name = sc.nextLine();
			
			Devices device = new Devices(name);
			network.addDevice(device);
		}
		
		network.simulationCommunication();
		sc.close();
	}
}
