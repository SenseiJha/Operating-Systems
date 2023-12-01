package File_Access;

import java.util.ArrayList;
import java.util.List;

public class Sequential_Access {
	public static void main(String[] args) {
		List<String> file = new ArrayList<>();
		
		file.add("Line1");
		file.add("Line2");
		file.add("Line3");
		file.add("Line4");
		file.add("Line5");
		
		for(String line : file) {
			System.out.println(line);
		}
	}
}