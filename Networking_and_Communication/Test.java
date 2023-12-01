package Networking_and_Communication;

import java.util.Map;
import java.util.Scanner;

public class Test {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of nodes in a network : ");
		int n = sc.nextInt();
		
		Network network = new Network();
		for(int i = 1;i <= n;i++) {
			System.out.println("Enter a name for this node : ");
			String name = sc.next();
			
			Network_Node node = new Network_Node(name);
			
			System.out.println("Enter the number of neighbors for this node : ");
			int k = sc.nextInt();
			
			for(int j = 1;j <= k;j++) {
				System.out.println("Enter the neighbouring node : ");
				String neighbor = sc.next();
				
				Network_Node neighbourNode = new Network_Node(neighbor);
				
				System.out.println("Enter the value of the edge connected to that node : ");
				int value = sc.nextInt();
				
				node.addNeighbors(neighbourNode, value);
			}
			network.addNode(node);
		}
		
		System.out.println("Enter the source node name : ");
		String name = sc.next();
		
		while(true) {
			if(network.getNodes().contains(name)) {
				break;
			}
			else {
				System.out.println("Sorry Node with that name does not exist");
			}
		}
		Network_Node source = new Network_Node(name);
		
		//Dijkstars Algorithms Implementation
		Map<Network_Node, Integer> d_distances = Dijkstras_Algorithm.searchShortestPath(network, source);
		for(Map.Entry<Network_Node, Integer> entry : d_distances.entrySet()) {
			System.out.println("From : " + source.getName() + " To : " + entry.getKey().getName() + " : " + entry.getValue());
		}
		
		//Bellmann Ford Algorithm
		Map<Network_Node, Integer> b_distances = Bellman_Ford_Algorithm.shortestPath(network, source);
		for(Map.Entry<Network_Node, Integer> entry : b_distances.entrySet()) {
			System.out.println("From : " + source.getName() + " To : " + entry.getKey().getName() + " : " + entry.getValue());
		}
		sc.close();
	}
}
