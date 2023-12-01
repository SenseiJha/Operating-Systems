package Networking_and_Communication;

import java.util.HashMap;
import java.util.Map;

public class Network_Node {
	private String name;
	private Map<Network_Node, Integer> neighbors = new HashMap<>();
	
	public Network_Node(String name) {
		this.name = name;
	}
	
	public void addNeighbors(Network_Node neighbor, int cost) {
		neighbors.put(neighbor, cost);
	}

	public String getName() {
		return name;
	}

	public Map<Network_Node, Integer> getNeighbors() {
		return neighbors;
	}
	
}
