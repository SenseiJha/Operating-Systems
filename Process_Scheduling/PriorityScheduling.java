package Process_Scheduling;

import java.util.LinkedList;
import java.util.Queue;

public class PriorityScheduling {
	static class Process {
		
		public Process(String name, int priority, int time) {
			this.name = name;
			this.time = time;
			this.priority = priority;
		}
		String name;
		int priority;
		int time;
	}
	
	public static void main(String[] args) {
		Queue<Process> q = new LinkedList<>();
		
		q.add(new Process("P1", 4, 23));
		q.add(new Process("P2", 2, 25));
		q.add(new Process("P3", 6, 12));
		q.add(new Process("P4", 3, 19));
		q.add(new Process("P5", 2, 13));
		q.add(new Process("P6", 3, 31));
		q.add(new Process("P7", 1, 9));
		q.add(new Process("P8", 5, 4));
		
		while(!q.isEmpty()) {
			Process p = q.poll();
			System.out.println("Running Process : " + p.name);
		}
	}
}
