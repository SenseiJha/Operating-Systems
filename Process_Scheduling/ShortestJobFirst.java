package Process_Scheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShortestJobFirst {
	static class Process {
		String name;
		int burstTime;
		
		Process(String name, int burstTime){
			this.name = name;
			this.burstTime = burstTime;
		}
	}
	public static void main(String[] args) {
		List<Process> processes = new ArrayList<>();
		
		processes.add(new Process("P1", 8));
		processes.add(new Process("P2", 3));
		processes.add(new Process("P3", 2));
		processes.add(new Process("P4", 26));
		processes.add(new Process("P5", 33));
		processes.add(new Process("P6", 17));
		
		Collections.sort(processes, Comparator.comparingInt(p -> p.burstTime));
		
		for(Process p : processes) {
			System.out.println("Running Process : " + p.name);
		}
	}
}
