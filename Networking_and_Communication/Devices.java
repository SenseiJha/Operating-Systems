package Networking_and_Communication;

public class Devices {
	private String name;
	
	public Devices(String name) {
		this.name = name;
	}
	
	public void receivePacket(Packet packet) {
		System.out.println(name + " received packet from " + packet.getSource() + " to " + packet.getDestination() + " with data : " + packet.getData());
	}
	
	public void sendPacket(Packet packet, Devices destination) {
		System.out.println(name + " sending packet to " + destination.name + " with data : " + packet.getData());
		destination.receivePacket(packet);
	}
}
