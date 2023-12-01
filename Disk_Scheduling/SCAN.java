package Disk_Scheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SCAN {
	public static void main(String[] args) {
		int requests[] = {98, 183, 37, 122, 104, 124, 65, 67, 45, 54,23, 53, 98, 40, 47};
		int head = 53;
		boolean upward = true;
		
		List<Integer> remaining = new ArrayList<>();
		for(int request : requests) {
			remaining.add(request);
		}
		
		int totalTime = 0;
		
		while(remaining.isEmpty() == false) {
			if(upward) {
				Collections.sort(remaining);
			}
			else {
				Collections.sort(remaining, Collections.reverseOrder());
			}
			
			int closest = remaining.get(0);
			remaining.remove(0);
			
			totalTime += Math.abs(head - closest);
			head = closest;
			
			if(head == 0 || head == 199) {
				upward = !upward;
			}
		}
		System.out.println("Total Seek Time : " + totalTime);
	}
}
