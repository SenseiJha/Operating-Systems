package Concurrency_Synchronization;

import java.util.concurrent.Semaphore;

public class Semaphores {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(4);
		Runnable task = () -> {
			try {
				semaphore.acquire();
				System.out.println("Resource Acquired.");
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				semaphore.release();
				System.out.println("Resource released.");
			}
		};
		
		for(int i = 0;i < 5;i++) {
			new Thread(task).start();
		}
	}
}
