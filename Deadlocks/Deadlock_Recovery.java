package Deadlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock_Recovery {
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
		
		new Thread(() -> {
			try {
				Thread.sleep(3000);
				t2.interrupt();
				System.out.println("Thread 2 interrupted for deadlock recovery.");
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}