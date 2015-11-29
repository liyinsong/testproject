package lys.webservice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(12345);
		
		while(true) {
			DataInputStream dataInputStream = null;
			DataOutputStream dataOutPutStream = null;
			try {
				Socket socket = serverSocket.accept();
				
				dataInputStream = new DataInputStream(socket.getInputStream());
				String name = dataInputStream.readUTF();
				
				dataOutPutStream = new DataOutputStream(socket.getOutputStream());
				String result = "result..." + name;
				dataOutPutStream.writeUTF(result);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(dataInputStream != null) {
					dataInputStream.close();
				}
				if(dataOutPutStream != null) {
					dataOutPutStream.close();
				}
			}
		}

	}

}
