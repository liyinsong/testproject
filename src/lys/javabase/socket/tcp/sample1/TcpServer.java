package lys.javabase.socket.tcp.sample1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(10003);
		
		Socket socket = ss.accept();
		
		String ip = socket.getInetAddress().getHostAddress();
		
		System.out.println("from IP: " + ip);
		
		InputStream is = socket.getInputStream();
		
		byte[] buff = new byte[1024];
		
		int length = is.read(buff);
		
		System.out.println(new String(buff, 0, length));
		
		socket.close();
		
		ss.close();

	}

}
