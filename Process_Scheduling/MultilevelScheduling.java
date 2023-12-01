package Process_Scheduling;

import java.util.LinkedList;
import java.util.Queue;

public class MultilevelScheduling {
	static class Process{
		String name;
		int time;
		boolean highPriority;
		
		Process(String name, int time, boolean highPriority) {
			this.name = name;
			this.time = time;
			this.highPriority = highPriority;
		}
	}
	public static void main(String[] args) {
		Queue<Process> high = new LinkedList<>();
		Queue<Process> low = new LinkedList<>();
		
		high.add(new Process("PH1",8, true));
		high.add(new Process("PH2",5, true));
		
		low.add(new Process("PL1", 4, false));
		low.add(new Process("PL2", 3, false));
		low.add(new Process("PL3", 9, false));
		low.add(new Process("PL4", 6, false));
		
		while((!high.isEmpty()) || (!low.isEmpty())) {
			if(!high.isEmpty()) {
				Process p = high.poll();
				System.out.println("Running Process : " + p.name);
			}
			else {
				Process p = low.poll();
				System.out.println("Running Process : " + p.name);
			}
		}
	}
}
