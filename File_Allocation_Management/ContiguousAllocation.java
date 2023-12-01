package File_Allocation_Management;

import java.util.HashMap;
import java.util.Map;

public class ContiguousAllocation {
	static class File {
		String name;
		int startBlock;
		int size;
		
		public File(String name, int startBlock, int size) {
			this.name = name;
			this.startBlock = startBlock;
			this.size = size;
		}
	}
	public static void main(String[] args) {
		Map<String, File> table = new HashMap<>();
		
		table.put("f1", new File("f1", 0, 5));
		table.put("f2", new File("f2", 5, 8));
		table.put("f3", new File("f3", 8, 14));
		table.put("f4", new File("f4", 14, 23));
		table.put("f5", new File("f5", 23, 38));
		
		for(File file : table.values()) {
			System.out.println("File : " + file.name);
			int start = file.startBlock;
			int end = file.startBlock + file.size - 1;
			System.out.println("Start Block : " + start);
			System.out.println("End Block : " + end);
			System.out.println("Blocks Allocated : " + file.size);
		}
	}
}