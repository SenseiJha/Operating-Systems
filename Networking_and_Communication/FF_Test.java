package Networking_and_Communication;

import java.util.Scanner;

public class FF_Test {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices : ");
		int n = sc.nextInt();
		
		int graph[][] = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the values for column : " + i + " :- ");
			for(int j = 0; j < n; j++) {
				
				System.out.println("Enter value : ");
				int value = sc.nextInt();
				
				graph[i][j] = value;
			}
		}
		
		Ford_Fulkerson_Algorithm f = new Ford_Fulkerson_Algorithm(graph);
		
		System.out.println("Enter the source value");
		int source = sc.nextInt();
		
		System.out.println("Enter the sink value");
		int sink = sc.nextInt();
		
		int  maxFlow = f.maxFlow(source, sink);
		
		System.out.println("Max Flow : " + maxFlow);
		sc.close();
	}
}
