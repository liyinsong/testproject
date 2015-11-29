package lys.webservice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = null;
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream = null;
		
		try {
			socket = new Socket("127.0.0.1", 12345);
			
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataOutputStream.writeUTF("clinetAAA");;
			
			dataInputStream = new DataInputStream(socket.getInputStream());
			String result = dataInputStream.readUTF();
			System.out.println("from server side result is: " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(socket != null) {
				socket.close();
			}
			if(dataInputStream != null) {
				dataInputStream.close();
			}
			if(dataOutputStream != null) {
				dataOutputStream.close();
			}
		}
		
	}

}
