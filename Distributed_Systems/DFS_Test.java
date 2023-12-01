package Distributed_Systems;

import java.util.Scanner;

public class DFS_Test {
	public static void main(String[] args) {
		Distributed_File_System dfs = new Distributed_File_System();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of nodes : ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter a name for the node : ");
			String name = sc.next();
			
			System.out.println("Enter the number of files in : " + name);
			int k = sc.nextInt();
			
			dfs.addNode(name);
			
			for(int j = 0; j < k; j++) {
				System.out.println("Enter file name");
				String file = sc.next();
				
				System.out.println("Enter the data in file : " + file);
				String data = sc.nextLine();
				
				dfs.uploadFile(name, file, data);
			}
		}
		
		System.out.println("Enter the name of the node : ");
		String name = sc.next();
		
		System.out.println("Enter the name of the file : ");
		String file = sc.next();
		
		String data = dfs.readFile(name, file);
		System.out.println("Data : " + data);
		
		sc.close();
	}
}
