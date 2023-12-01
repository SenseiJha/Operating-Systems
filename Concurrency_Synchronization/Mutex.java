package Concurrency_Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mutex {
	public static void main(String[] args) {
		Lock mutex = new ReentrantLock();
		
		Runnable task = () -> {
			mutex.lock();
			try {
				System.out.println("Critical Section. Protected by Mutex.");
			}			
			finally {
				mutex.unlock();
			}
		};
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		t1.start();
		t2.start();
	}
}
