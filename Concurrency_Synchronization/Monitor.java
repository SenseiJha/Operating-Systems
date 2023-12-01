package Concurrency_Synchronization;

public class Monitor {
	static class SharedResources{
		void performTask() {
			System.out.println("Task performed by thread : " + Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {
		SharedResources s = new SharedResources();
		
		Runnable task = () -> {
			synchronized (s) {
				s.performTask();
			}
		};
		
		for(int i = 0;i < 5;i++) {
			new Thread(task).start();
		}
	}
}
