package Deadlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock_Detection {
	public static void main(String[] args) {
		Lock resource1 = new ReentrantLock();
		Lock resource2 = new ReentrantLock();
		
		Thread t1 = new Thread(() -> {
			resource1.lock();
			System.out.println("Thread 1 : Acquired Resource 1");
			resource2.lock();
			System.out.println("Thread 1 : Acquired Resource 2");
			resource2.unlock();
			resource1.unlock();
		});
		
		Thread t2 = new Thread(() -> {
			resource2.lock();
			System.out.println("Thread 2 : Acquired Resource 2");
			resource1.lock();
			System.out.println("Thread 2 : Acquired Resource 1");
			resource1.unlock();
			resource2.unlock();
		});
		
		t1.start();
		t2.start();
		
		while(true) {
			if(resource1.tryLock()&&resource2.tryLock()) {
				System.out.println("Deadlock detected.");
				break;
			}
		}
	}
}