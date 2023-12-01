package Memory_Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DemandPaging {
	static class Page {
		int pageNumber;
		boolean isLoaded;
		
		Page(int pageNumber, boolean isLoaded){
			this.isLoaded = isLoaded;
			this.pageNumber = pageNumber;
		}
	}
	public static void main(String[] args) {
		
		List<Page> pages = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no of pages : ");
		int n = sc.nextInt();
		boolean res[] = {true, false};
		Random r = new Random();
		for(int i = 0;i < n;i++) {
			int j = r.nextInt(2);
			pages.add(new Page(i + 1, res[j]));
		}
		System.out.println("Pages Entered !!!");
		
		System.out.println("Enter the page to be searched !!!");
		int virtualPage = sc.nextInt();
		
		while(virtualPage <= n) {
			int pageIndex = -1;
			
			for(int i = 0;i < pages.size(); i++) {
				if(pages.get(i).pageNumber == virtualPage) {
					pageIndex = i;
					break;
				}
			}
			
			if(pageIndex != -1) {
				if(pages.get(pageIndex).isLoaded) {
					System.out.println("Page already in Memory");
					break;
				}
				else {
					System.out.println("Page fault! Loading page into memory");
					pages.get(pageIndex).isLoaded = true;
				}
			}
			else {
				System.out.println("Page Not found");
				break;
			}
		}
		
		sc.close();
	}
}
