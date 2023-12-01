package Concurrency_Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadersWritersExample {
    static int sharedResource = 0;
    static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Reader()).start();
            new Thread(new Writer()).start();
        }
    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            while (true) {
                Lock readLock = lock.readLock();
                readLock.lock();
                
                System.out.println("Reader reads: " + sharedResource);

                readLock.unlock();
                
                // Reading time...

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Writer implements Runnable {
        @Override
        public void run() {
            while (true) {
                Lock writeLock = lock.writeLock();
                writeLock.lock();
                
                sharedResource++;
                System.out.println("Writer writes: " + sharedResource);

                writeLock.unlock();
                
                // Writing time...

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}