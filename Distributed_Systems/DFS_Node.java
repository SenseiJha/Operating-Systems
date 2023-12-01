package Distributed_Systems;

import java.util.HashMap;
import java.util.Map;

public class DFS_Node {
	private String name;
	private Map<String, String> files;
	
	public DFS_Node(String name) {	
		this.setName(name);
		files = new HashMap<>();
	}
	
	public void addFile(String file, String data) {
		files.put(file, data);
	}
	
	public String getFileData(String file) {
		return files.getOrDefault(file, "File Not Found !!");//Important
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
