package Disk_Scheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C_SCAN {
	public static void main(String[] args) {
		int requests[] = {98, 183, 37, 122, 14, 124, 65, 67, 45, 54,23, 53, 98, 40, 47};
		int head = 53;
		
		List<Integer> remaining = new ArrayList<>();
		
		for(int request : requests) {
			remaining.add(request);
		} 
		
		int totalTime = 0;
		
		while(remaining.isEmpty() == false) {
			Collections.sort(remaining);
			
			int i =  remaining.indexOf(head);
			
			if(i != -1) {
				remaining.remove(i);
			}
			
			if(remaining.isEmpty() == false) {
				int closest = remaining.get(0);
				remaining.remove(0);
				totalTime += Math.abs(head - closest);
				head = closest;
			}
			else {
				totalTime += Math.abs(head - 199);
				head = 199;
			}
		}
		System.out.println("Total Seek Time : " + totalTime);
	}
}
