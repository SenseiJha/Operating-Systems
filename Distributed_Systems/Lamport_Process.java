package Distributed_Systems;

public class Lamport_Process implements Runnable {
	
	private int Id;
	private Lamport_Clock clock;
	
	public Lamport_Process(int Id, Lamport_Clock clock) {
		this.Id = Id;
		this.clock = clock;
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Process : " + Id + " executed local event at time : " + clock.getTime());
			clock.updateTime(clock.getTime());
			
			int receivedTime = clock.getTime();
			receivedTime += 2;
			clock.updateTime(receivedTime);
			System.out.println("Process : " + Id + " sends message at time " + clock.getTime());
			
			receivedTime = clock.getTime();
			receivedTime += 1;
			clock.updateTime(receivedTime);
			System.out.println("Process : " + Id + " receives message at time : " + clock.getTime());
		}
	}
}