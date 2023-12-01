package Networking_and_Communication;

import java.util.ArrayList;
import java.util.List;

public class Network {
	private List<Network_Node> nodes = new ArrayList<>();
	
	public void addNode(Network_Node node) {
		nodes.add(node);
	}
	
	public List<Network_Node> getNodes(){
		return nodes;
	}
}
