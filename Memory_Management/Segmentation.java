package Memory_Management;

import java.util.HashMap;
import java.util.Map;

public class Segmentation {
	
	static class Segment {
		int baseAddress;
		int length;
		
		public Segment(int baseAddress, int length) {
			super();
			this.baseAddress = baseAddress;
			this.length = length;
		}
	}
	public static void main(String[] args) {
		Map<String, Segment> segments = new HashMap<>();
		
		segments.put("Code", new Segment(0, 4593));
		segments.put("Data", new Segment(4593, 454534));
		
		String segmentName = "Code";
		int offset = 200;
		
		Segment segment = segments.get(segmentName);
		
		if(segment != null) {
			int physicalAddress = segment.baseAddress + offset;
			System.out.println("Physical Address : " + physicalAddress);
		}
		else {
			System.out.println("Segment not found.");
		}
	}
}
