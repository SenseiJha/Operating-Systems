package Disk_Scheduling;

import java.util.ArrayList;
import java.util.List;

public class Shortest_Seek_Time_First {
	public static void main(String[] args) {
        int[] requests = {98, 183, 37, 122, 14, 124, 65, 67, 37, 47, 98, 76, 90, 23};
        int headPosition = 53;

        List<Integer> remainingRequests = new ArrayList<>();
        for (int request : requests) {
            remainingRequests.add(request);
        }

        int totalSeekTime = 0;
        
        while (!remainingRequests.isEmpty()) {
            int minSeek = Integer.MAX_VALUE;
            int closestRequest = -1;

            for (int request : remainingRequests) {
                int seek = Math.abs(headPosition - request);
                if (seek < minSeek) {
                    minSeek = seek;
                    closestRequest = request;
                }
            }

            totalSeekTime += minSeek;
            headPosition = closestRequest;
            remainingRequests.remove((Integer) closestRequest);
        }

        System.out.println("Total Seek Time (SSTF): " + totalSeekTime);
    }
}