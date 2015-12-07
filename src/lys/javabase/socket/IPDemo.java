package lys.javabase.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.toString());
		System.out.println(address.getHostAddress());
	}

}
