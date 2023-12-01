package Directory_Structures;

import java.util.HashMap;
import java.util.Map;

public class Single_Level {
	public static void main(String[] args) {
		Map<String, String> table = new HashMap<>();
		table.put("file1", "user1");
		table.put("file2", "user2");
		table.put("file3", "user3");
		
		for(Map.Entry<String, String> entry : table.entrySet()) {
			System.out.println("File : " + entry.getKey() + ", Owner : " + entry.getValue());
		}
	}
}
