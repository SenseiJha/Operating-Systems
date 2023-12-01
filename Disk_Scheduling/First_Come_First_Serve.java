package Disk_Scheduling;

public class First_Come_First_Serve {
	public static void main(String[] args) {
		int requests[] = {98, 183, 37, 122, 14, 124, 65, 67, 45, 54,23, 53, 98, 40, 47};
		int head = 53;
		
		int totalTime = 0;
		for(int request : requests) {
			totalTime += Math.abs(head - request);
			head = request;
		}
		System.out.println("Total First_Come_First_Serve Time : " + totalTime);
	}
}