package lys.javabase.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket ds = new DatagramSocket(10000);

		byte[] buf = new byte[1024];
		
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		ds.receive(dp);
		
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(), 0, dp.getLength());
		int port = dp.getPort();
		
		System.out.println("ip:" + ip + " port:" + port + " data:" + data);
		
		ds.close();
		
	}

}
