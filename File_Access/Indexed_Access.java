package File_Access;

import java.util.HashMap;
import java.util.Map;

public class Indexed_Access {
	public static void main(String[] args) {
		Map<Integer, String> table = new HashMap<>();
		table.put(1, "Record 1");
		table.put(2, "Record 2");
		table.put(3, "Record 3");
		table.put(4, "Record 4");
		table.put(5, "Record 5");
		table.put(6, "Record 6");
		
		int record = 5;
		
		System.out.println("Record " + record + " : " + table.get(record));
	}
}