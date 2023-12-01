package Security_and_Access_Control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSClient {
	public static void main(String[] args) {
		String hostname = "localhost";
		int port = 4433;
		
		try {
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, null, new java.security.SecureRandom());
			
			SSLSocketFactory socketFactory = sslContext.getSocketFactory();
			SSLSocket socket = (SSLSocket) socketFactory.createSocket(hostname, port);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			out.println("Hello, server! ");
			
			String response = in.readLine();
			System.out.println("Received from server : " + response);
			
			in.close();
			out.close();
			socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
