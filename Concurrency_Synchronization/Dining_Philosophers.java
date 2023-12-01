package Concurrency_Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dining_Philosophers {
	public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        Lock[] forks = new ReentrantLock[numberOfPhilosophers];

        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks[i] = new ReentrantLock();
        }

        for (int i = 0; i < numberOfPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % numberOfPhilosophers]);
            new Thread(philosophers[i]).start();
        }
    }

    static class Philosopher implements Runnable {
        private final int id;
        private final Lock leftFork;
        private final Lock rightFork;

        Philosopher(int id, Lock leftFork, Lock rightFork) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        @Override
        public void run() {
            while (true) {
                think();
                eat();
            }
        }

        void think() {
            System.out.println("Philosopher " + id + " is thinking.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void eat() {
            if (leftFork.tryLock()) {
                try {
                    if (rightFork.tryLock()) {
                        try {
                            System.out.println("Philosopher " + id + " is eating.");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } finally {
                            rightFork.unlock();
                        }
                    }
                } finally {
                    leftFork.unlock();
                }
            }
        }
    }
}
