package Distributed_Systems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paxos_Algorithm {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of nodes : ");
		int n = sc.nextInt();
		
		Paxos_Network network = new Paxos_Network();
		List<Paxos_Node> nodes = new ArrayList<>();
		for(int i = 0; i < n;i++) {
			System.out.println("Enter the ID for node " + i + " : ");
			int id = sc.nextInt();
			
			Paxos_Node node = new Paxos_Node(id);
			
			nodes.add(node);
			network.addNode(id);
		}
		System.out.print("{ ");
		for(Paxos_Node node: nodes) {
			System.out.print(node.getId() + ", ");
		}
		System.out.print("}");
		System.out.println();
		System.out.println("Enter an ID to be searched : ");
		int proposedId = sc.nextInt();
		
		System.out.println("Enter a value to be searched : ");
		int proposedValue = sc.nextInt();
		
		System.out.println("Enter a value : ");
		int value = sc.nextInt();
		
		int decidedValue = network.run(proposedId, proposedValue, value);
		
		System.out.println("Decided Value : " + decidedValue);
		
		sc.close();
	}
}