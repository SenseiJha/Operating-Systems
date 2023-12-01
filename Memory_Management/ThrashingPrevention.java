package Memory_Management;

import java.util.Random;

public class ThrashingPrevention {
	public static void main(String[] args) {
		int available = 512;
		int totalProcesses = 20;
		int threshold = 10;
		
		int table[] = new int[totalProcesses];
		
		Random random = new Random();
		
		for(int i = 0;i < totalProcesses;i++) {
			int required = random.nextInt(15) + 1;
			table[i] = required;
			
			if(required > available) {
				System.out.println("Process " + i + " requires more memory than available.");
			}
			else {
				System.out.println("Process " + i + " allocated " + required + " pages.");
				available -= required;
			}
			
			if(available < threshold) {
				System.out.println("Thrashing Detected !! Taking Action !!");
				available += threshold;
			}
		}
	}
}