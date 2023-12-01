package Memory_Management;

public class Paging {

	public static void main(String[] args) {
		int pageSize = 4858;
		int virtualAddress = 984952;
		
		
		int index = virtualAddress / pageSize;
		int offset = virtualAddress % pageSize;
		
		System.out.println("Page Index : " + index);
		System.out.println("Offset : " + offset);
	}

}
