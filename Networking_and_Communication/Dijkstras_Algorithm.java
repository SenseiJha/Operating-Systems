package Networking_and_Communication;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstras_Algorithm {
	
	public static Map<Network_Node, Integer> searchShortestPath(Network network, Network_Node source) {
		Map<Network_Node, Integer> distances = new HashMap<>();
		Set<Network_Node> visited = new HashSet<>();
		PriorityQueue<Network_Node> queue = new PriorityQueue<>();
		
		for(Network_Node node : network.getNodes()) {
			if(node.equals(source)) {
				distances.put(node, 0);
			}
			else {
				distances.put(node, Integer.MAX_VALUE);
			}
			queue.add(node);
		}
		
		while(queue.isEmpty() == false) {
			Network_Node current = queue.poll();
			visited.add(current);
			
			for(Map.Entry<Network_Node, Integer> entry : current.getNeighbors().entrySet()) {
				Network_Node neighbor = entry.getKey();
				int cost = entry.getValue();
				int newDistance = distances.get(current) + cost;
				
				if(visited.contains(neighbor) == false && newDistance < distances.get(neighbor)) {
					distances.put(neighbor, newDistance);
					queue.remove(neighbor);
					queue.add(neighbor);
				}
			}
		}
		return distances;	
	}
}
