package lys.javabase.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSend {

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		
		byte[] buf = "你好，哥们我来了".getBytes();
		
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);
		
		ds.send(dp);
		
		ds.close();

	}

}
