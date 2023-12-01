package Distributed_Systems;

import java.util.HashMap;
import java.util.Map;

public class Paxos_Network {
	private Map<Integer, Paxos_Node> nodes;
	
	public Paxos_Network() {
		nodes = new HashMap<>();
	}
	
	public void addNode(int id) {
		nodes.put(id, new Paxos_Node(id));
	}
	
	public Paxos_Node getNode(int id) {
		return nodes.get(id);
	}
	
	public int run(int proposerId, int proposedValue, int value) {
		Paxos_Node proposer = nodes.get(proposerId);
		int highestAcceptedValue = proposer.preparationPeriod(proposedValue);
		
		if(highestAcceptedValue == -1) {
			return -1;
		}
		for(Paxos_Node node : nodes.values()) {
			node.acceptingPeriod(proposedValue, highestAcceptedValue);
		}
		return highestAcceptedValue;
	}
}