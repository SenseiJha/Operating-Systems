package Process_Scheduling;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {
	static class Process{
		String name;
		int remainingTime;
		
		Process(String name, int remainingTime) {
			this.name = name;
			this.remainingTime = remainingTime;
		}
	}
	public static void main(String[] args) {
		Queue<Process> q = new LinkedList<>();
		
		q.add(new Process("P1", 17));
		q.add(new Process("P2", 19));
		q.add(new Process("P3", 24));
		q.add(new Process("P4", 23));
		q.add(new Process("P5", 22));
		q.add(new Process("P6", 15));
		q.add(new Process("P7", 12));
		q.add(new Process("P8", 42));
		
		int timeQuantum = 4;
		
		while(!q.isEmpty()) {
			Process p = q.poll();
			System.out.println("Runnning Process : " + p.name);
			
			if(p.remainingTime > timeQuantum) {
				p.remainingTime -= timeQuantum;
				System.out.println("Time : " + timeQuantum + " units.");
				q.add(p);
			}
			else {
				System.out.println("Time : " + p.remainingTime + " units.");
			}
		}
	}
}