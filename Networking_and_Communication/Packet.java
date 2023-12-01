package Networking_and_Communication;

public class Packet {
	private String source;
	private String destination;
	private String data;
	
	public Packet(String source, String destination, String data) {
		this.source = source;
		this.destination = destination;
		this.data = data;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public String getData() {
		return data;
	}
	
}
