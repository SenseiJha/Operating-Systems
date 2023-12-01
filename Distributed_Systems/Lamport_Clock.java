package Distributed_Systems;

import java.util.concurrent.atomic.AtomicInteger;

public class Lamport_Clock {
	private AtomicInteger logicalTime;
	
	public Lamport_Clock() {
		logicalTime = new AtomicInteger(0);
	}
	
	public int getTime() {
		return logicalTime.get();
	}
	
	public void updateTime(int receivedTime) {
		int currentMax = logicalTime.get();
		int newT = Math.max(currentMax, receivedTime) + 1;
		logicalTime.set(newT);
	}
}