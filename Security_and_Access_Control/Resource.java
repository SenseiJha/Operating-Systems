package Security_and_Access_Control;

public class Resource {
	private String name;
	private String owner;
	
	public Resource(String name, String owner) {
		this.name = name;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}
	
	public String getOwner() {
		return owner;
	}
}
