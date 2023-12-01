package Networking_and_Communication;

import java.util.ArrayList;
import java.util.List;

public class Network_For_Devices {
	private List<Devices> devices = new ArrayList<>();
	
	public void addDevice(Devices device) {
		devices.add(device);
	}
	
	public void simulationCommunication() {
		Devices sender = devices.get(0);
		Devices receiver = devices.get(1);
		
		Packet packet = new Packet(sender.toString(), receiver.toString(), "Hello, World!");
		sender.sendPacket(packet, receiver);
	}
}
