package Distributed_Systems;

import java.util.HashMap;
import java.util.Map;

public class Distributed_File_System {
	private Map<String, DFS_Node> nodes;
	
	public Distributed_File_System() {
		nodes = new HashMap<>();
	}
	
	public void addNode(String name) {
		nodes.put(name, new DFS_Node(name));
	}
	
	public void uploadFile(String name, String file, String data) {
		DFS_Node node = nodes.get(name);
		
		if(node != null) {
			node.addFile(file, data);
			System.out.println(file + " file uploaded to " + name);
		}
		else {
			System.out.println("Node not found.");
		}
	}
	
	public String readFile(String name, String file) {
		 DFS_Node node = nodes.get(name);
		 if(node != null) {
			 return node.getFileData(file);
		 }
		 else {
			 return "Node not found";
		 }
	}
}