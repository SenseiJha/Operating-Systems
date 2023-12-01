package Networking_and_Communication;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ford_Fulkerson_Algorithm {
	private int residualGraph[][];
	
	
	public Ford_Fulkerson_Algorithm(int graph[][]) {
		this.residualGraph = new int[graph.length][graph[0].length];
		
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph[0].length; j++) {
				residualGraph[i][j] = graph[i][j];
			}
		}
	}
	
	public boolean BFS(int graph[][], int parent[], int source, int target) {
		boolean visited[] = new boolean[graph.length];
		Arrays.fill(visited, false);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		visited[source] = true;
		parent[source] = -1;
		
		while (q.isEmpty() == false) {
			int current = q.poll();
			
			for(int neighbor = 0; neighbor < graph.length; neighbor++) {
				if(visited[neighbor] == false && residualGraph[current][neighbor] > 0) {
					q.add(neighbor);
					parent[neighbor] = current;
					visited[neighbor] = true;
				}
			}
		}
		return visited[target];
	}
	
	public int maxFlow(int source, int target) {
		int parent[] = new int[residualGraph.length];
		int maxFlow = 0;
		
		while(BFS(residualGraph, parent, source, target)) {
			int pathFlow = Integer.MAX_VALUE;
			int vertex = target;
			
			while(vertex != source) {
				int prev = parent[vertex];
				pathFlow = Math.min(pathFlow, residualGraph[prev][vertex]);
				vertex = prev;
			}
			
			vertex = target;
			
			while(vertex != source) {
				int prev = parent[vertex];
				residualGraph[prev][vertex] -= pathFlow;
				residualGraph[vertex][prev] += pathFlow;
				vertex = prev;
			}
			
			maxFlow += pathFlow;
		}
		return maxFlow;	
	}
}