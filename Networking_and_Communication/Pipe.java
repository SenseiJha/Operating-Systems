package Networking_and_Communication;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Pipe {
	public static void main(String[] args) {
		try {
			PipedOutputStream out = new PipedOutputStream();
			PipedInputStream in = new PipedInputStream(out);
			
			Thread writer = new Thread(() -> {
				try {
					out.write("Hello World !!!!".getBytes());
					out.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			});
			
			Thread reader = new Thread(() -> {
				try {
					int data;
					while((data = in.read()) != -1) {
						System.out.print((char)data);
					}
					in.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			});
			
			writer.start();
			reader.start();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
