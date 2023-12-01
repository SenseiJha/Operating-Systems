package Directory_Structures;

import java.util.HashMap;
import java.util.Map;

public class Two_Level {
	static class User {
		String name;
		Map<String, String> table = new HashMap<>();
		
		public User(String name) {
			this.name = name;
		}
	}
	public static void main(String[] args) {
		Map<String, User> table = new HashMap<>();
		
		table.put("User1", new User("User1"));
		table.put("User2", new User("User2"));
		
		table.get("User1").table.put("File1", "File1_Owner");
		table.get("User1").table.put("File2", "File2_Owner");
		table.get("User2").table.put("File3", "File3_Owner");
		table.get("User2").table.put("File4", "File4_Owner");
		
		for(User user : table.values()) {
			System.out.println("User : " + user.name);
			for(Map.Entry<String, String> entry : user.table.entrySet()) {
				System.out.println("File : " + entry.getKey() + ", Owner : " + entry.getValue());
			}
		}
	}
}
