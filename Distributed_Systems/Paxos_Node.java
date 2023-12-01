package Distributed_Systems;

public class Paxos_Node {
	private int id;
	private int proposedValue;
	private int acceptedValue;
	
	public Paxos_Node(int id) {
		this.setId(id);
	}
	
	public int preparationPeriod(int proposedValue) {
		if(proposedValue > this.proposedValue) {
			this.proposedValue = proposedValue;
			return this.acceptedValue;
		}
		return -1;
	}
	
	public void acceptingPeriod(int proposedValue, int value) {
		if(proposedValue >= this.proposedValue) {
			this.proposedValue = proposedValue;
			this.acceptedValue = value;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}