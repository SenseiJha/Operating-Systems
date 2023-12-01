package Security_and_Access_Control;

import java.util.HashMap;
import java.util.Map;

public class Access_Control_Manager {
	private Map<String, User> users = new HashMap<>();
	private Map<String, Resource> resources = new HashMap<>();
	
	public void addUser(User user) {
		users.put(user.getUsername(), user);
	}
	
	public void addResource(Resource resource) {
		resources.put(resource.getName(), resource);
	}
	
	public boolean Authenticate(String username, String password) {
		User user = users.get(username);
		return (user != null) && user.getPassword().equals(password);
	}
	
	public boolean Authorize(String username, String resource) {
		User user = users.get(username);
		Resource res = resources.get(resource);
		
		if(user != null && res != null) {
			if(user.getRole().equals("admin")) {
				return true;
			}
			else if(res.getOwner().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
