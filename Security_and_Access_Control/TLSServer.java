package Security_and_Access_Control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class TLSServer {
	public static void main(String[] args) {
		int port = 4433;
		
		try {
			SSLContext	sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, null, new java.security.SecureRandom());
			
			SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();
			
			SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(port);
			
			System.out.println("Server is ready an listening : ");
			
			while(true) {
				SSLSocket socket = (SSLSocket) serverSocket.accept();
				System.out.println("Connected to client : " + socket.getInetAddress());
				
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				
				String data;
				
				while((data = in.readLine()) != null) {
					System.out.println("Received : " + data);
					out.println("Server : " + data);
				}
				in.close();
				out.close();
				socket.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
