package Networking_and_Communication;

import java.util.HashMap;
import java.util.Map;

public class Bellman_Ford_Algorithm {
	public static Map<Network_Node, Integer> shortestPath(Network network, Network_Node source) {
		Map<Network_Node, Integer> distances = new HashMap<>();
		
		for(Network_Node node : network.getNodes()) {
			if(node.equals(source)) {
				distances.put(node, 0);
			}
			else {
				distances.put(node, Integer.MAX_VALUE);
			}
		}
		
		for(int i = 0; i < network.getNodes().size();i++) {
			for(Network_Node node : network.getNodes()) {
				for(Map.Entry<Network_Node, Integer> entry : node.getNeighbors().entrySet()) {
					Network_Node neighbor = entry.getKey();
					int cost = entry.getValue();
					int newDistance = distances.get(node) + cost;
					
					if(newDistance < distances.get(neighbor)) {
						distances.put(neighbor, newDistance);
					}
				}
			}
		}
		return distances;
	}
}
