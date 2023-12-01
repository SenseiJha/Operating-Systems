package Memory_Management;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PageReplacement {
	
	public static int LRU(List<Integer> pageReferences, int frames) {
		Set<Integer> cache = new LinkedHashSet<>();
		int faults = 0;
		
		for(int page : pageReferences) { 
			
			if(cache.contains(page) == false) {
				faults++;
				if(cache.size() >= frames) {
					cache.remove(cache.iterator().next());
				}
				cache.add(page);
			}
			else {
				cache.remove(page);
				cache.add(page);
			}
		}
		return faults;
	}
	
	public static int FIFO(List<Integer> pageReferences, int frames) {
		Queue<Integer> cache = new LinkedList<>();
		int faults = 0;
		
		for(int page : pageReferences) {
			if(cache.contains(page) == false) {
				faults++;
				if(cache.size() >= frames) {
					cache.poll();
				}
				cache.add(page);
			}
		}
		return faults;
	}
	
	public static int Optimal(List<Integer> pageReference, int frames) {
		Set<Integer> cache = new LinkedHashSet<>();
		int faults = 0;
		
		for(int i = 0;i < pageReference.size();i++) {
			int page = pageReference.get(i);
			if(cache.contains(page) == false) {
				faults++;
				if(cache.size() >= frames) {
					int farthestPageIndex = -1;
					int farthestIndex = -1;
					
					for(int c : cache) {
						int farthest = pageReference.subList(i, pageReference.size()).indexOf(c);
						if (farthest > farthestIndex) {
							farthestIndex = farthest;
							farthestPageIndex = c;	
						}
					}
					cache.remove(farthestPageIndex);
				}
				cache.add(page);
			}
		}
		return faults;
	}
	
	public static void main(String[] args) {
		List<Integer> pageReference = Arrays.asList(7,8,6,4,7,5,1,2,3,9,5,5,7,4,5,6,5,4,7,7,4,4);
		
		System.out.println(pageReference);
		System.out.println("Size : " + pageReference.size());
		
		System.out.println("LRU Replacement : " + LRU(pageReference, 4));
		System.out.println("FIFO Replacement : " + FIFO(pageReference, 4));
		System.out.println("Optimal Replacement : " + Optimal(pageReference, 4));
	}
}