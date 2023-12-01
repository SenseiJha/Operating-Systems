package File_Allocation_Management;

import java.util.HashMap;
import java.util.Map;

public class IndexedAllocation {
	static class File {
		String name;
		int blocks[];
		
		File(String name, int[] blocks) {
			this.blocks = blocks;
			this.name = name;
		}
	}
	
	public static void main(String[] args) {
		Map<String, File> table = new HashMap<>();
		
		table.put("f1", new File("f1",new int[] {5,4,6,7}));
		table.put("f2", new File("f2",new int[] {7,3,1}));
		table.put("f3", new File("f3",new int[] {9,2}));
		table.put("f4", new File("f4",new int[] {9,1,4,8}));
		
		for(File file : table.values()) {
			System.out.println("File Name : " + file.name);
			int blocks[] = file.blocks;
			System.out.println("Blocks Allocated");
			
			for(int block : blocks) {
				System.out.print(block + " ");
			}
			System.out.println("\n");
		}
	}
}
