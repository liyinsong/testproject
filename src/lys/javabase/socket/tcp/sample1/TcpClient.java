package lys.javabase.socket.tcp.sample1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("127.0.0.1", 10003);
		
		OutputStream out = socket.getOutputStream();
		
		out.write("tcp lai le".getBytes());
		
		socket.close();
	}

}
