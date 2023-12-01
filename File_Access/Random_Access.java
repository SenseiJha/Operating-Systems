package File_Access;

import java.io.RandomAccessFile;

public class Random_Access {
	public static void main(String[] args) {
		try {
			RandomAccessFile file = new RandomAccessFile("Test.txt","r");
			file.write("Sidhant Jha".getBytes());
			
			file.seek(7);
			byte buffer[] = new byte[5];
			file.read(buffer);
			System.out.println(new String(buffer));
			file.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}