package Distributed_Systems;

import java.util.Scanner;

public class Lamport_Clock_Synchronization {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lamport_Clock clock = new  Lamport_Clock();
		
		Thread t1 = new Thread(new Lamport_Process(1, clock));
		Thread t2 = new Thread(new Lamport_Process(2, clock));
		
		t1.start();
		t2.start();
		
		sc.close();
	}
}
