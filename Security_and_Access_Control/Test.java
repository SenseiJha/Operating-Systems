package Security_and_Access_Control;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Access_Control_Manager a = new Access_Control_Manager();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of users : ");
		int n = sc.nextInt();
		
		List<User> users = new ArrayList<>();
		List<Resource> files = new ArrayList<>();
		
		for(int i = 0;i < n;i++) {
			System.out.println("Enter your name : ");
			String username = sc.next();
			
			System.out.println("Enter password you want to set : ");
			String password = sc.next();
			
			System.out.println("Enter your role : ");
			String role = sc.next();
			
			System.out.println("Enter the file name : ");
			String fileName = sc.next();
			
			System.out.println("Enter the file owner name : ");
			String owner = sc.next();
			
			//DATABASE
			User user = new User(username, password, role);
			Resource file = new Resource(fileName, owner);
			
			a.addUser(user);
			a.addResource(file);
			
			files.add(file);
			users.add(user);
		}
		
		System.out.println("All users listed below : ");
		System.out.println(users);
		
		System.out.println("All files listed below : ");
		System.out.println(files);
		
		System.out.println("Enter your information asked below to access your files from here. ");
		
		System.out.println("Enter your username : ");
		String username = sc.next();
		
		System.out.println("Enter your password : ");
		String password = sc.next();
		
		System.out.println("Enter your file name : ");
		String fileName = sc.next(); 
		
		if(a.Authenticate(username, password)) {
			if(a.Authorize(username, fileName)) {
				System.out.println(username + " successfully mapped " + fileName);
			}
			else {
				System.out.println(username + " blocked!!!! File cannot be mapped....");
			}
		}
		else {
			System.out.println("Authentication failed for : " + username);
		}
		sc.close();
	}
}
