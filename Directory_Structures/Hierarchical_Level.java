package Directory_Structures;

import java.util.HashMap;
import java.util.Map;

public class Hierarchical_Level {
	static class Directory {
		String name;
		Map<String, Directory> subDirectory = new HashMap<>();
		Map<String, String> table = new HashMap<>();
		
		public Directory(String name) {
			this.name = name;
		}
	}
	
	public static void main(String[] args) {
		Map<String, Directory> table = new HashMap<>();
		
		table.put("Root", new Directory("Root"));
		
		table.get("Root").subDirectory.put("User1", new Directory("User1"));
		table.get("Root").subDirectory.put("User2", new Directory("User2"));
		
		table.get("Root").subDirectory.get("User1").table.put("File1", "File1_Owner");
		table.get("Root").subDirectory.get("User1").table.put("File2", "File2_Owner");
		table.get("Root").subDirectory.get("User1").table.put("File3", "File3_Owner");
		table.get("Root").subDirectory.get("User2").table.put("File4", "File4_Owner");
		table.get("Root").subDirectory.get("User2").table.put("File5", "File5_Owner");
		table.get("Root").subDirectory.get("User2").table.put("File6", "File6_Owner");
		
		for(Directory directory : table.values()) {
			System.out.println("Directory : " + directory.name);
			for(Map.Entry<String, Directory> subEntry : directory.subDirectory.entrySet()) {
				System.out.println("Sub-Directory : " + subEntry.getKey());
				for(Map.Entry<String, String> fileEntry : subEntry.getValue().table.entrySet()) {
					System.out.println("File : " + fileEntry.getKey() + ", Owner : " + fileEntry.getValue());
				}
			}
		}
	}
}