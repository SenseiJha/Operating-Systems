package Networking_and_Communication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Congestion_Control {
	private static final int MAX_WINDOW_SIZE = 15;
	private static final int MIN_WINDOW_SIZE = 2;
	private static final int THRESHOLD = 10;
	
	private int windowSize;
	private int threshold;
	private Lock lock;
	
	public Congestion_Control() {
		windowSize = MAX_WINDOW_SIZE;
		threshold = THRESHOLD;
		lock = new ReentrantLock();
	}
	
	public void sendData() {
		lock.lock();
		
		try {
			System.out.println("Sending " + windowSize + " packets.");
			Thread.sleep(100);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void receivedData(boolean isDuplicate) {
		lock.lock();
		try {
			if(isDuplicate) {
				handleDuplicateData();
			}
			else {
				increaseWindowSize();
			}
		}
		finally {
			lock.unlock();
		}
	}
	
	private void handleDuplicateData() {
		System.out.println("Received Duplicate data. Threshold : " + threshold + ", Window Size : " + windowSize);
		threshold = Math.max(windowSize/2, MIN_WINDOW_SIZE);
		windowSize = threshold + 3;
		System.out.println("Performing fast retransmit. New Threshold : " + threshold + ", New Window Size : " + windowSize);
	}
	
	private void increaseWindowSize() {
		if(windowSize < threshold) {
			windowSize++;
		}
		else {
			windowSize += 1/windowSize;
		}
		windowSize = Math.min(windowSize, MAX_WINDOW_SIZE);
		System.out.println("Received Data. New Window Size : " + windowSize);
	}
}
