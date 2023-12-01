package Process_Scheduling;

import java.util.LinkedList;
import java.util.Queue;

public class FirstComeFirstServe {
	static class Process {
		String name;
		int time;
		
		Process(String name, int time) {
			this.name = name;
			this.time = time;
		}
	}
	public static void main(String[] args) {
		Queue<Process> q = new LinkedList<>();
		 q.add(new  Process("P1", 8));
		 q.add(new  Process("P2", 18));
		 q.add(new  Process("P3", 12));
		 q.add(new  Process("P4", 7));
		 q.add(new  Process("P5", 4));
		 
		 while(!q.isEmpty()) {
			 Process p = q.poll();
			 
			 System.out.println("Process : " + p.name);
			 p.time--;
			 if(p.time > 0) {
				 q.add(p);
			 }
		 }
	}
}
