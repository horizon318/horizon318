package demo3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(8888);
			while(true) {
				Socket socket =serverSocket.accept();
				ServerThreads serverThreads=new ServerThreads(socket);
				serverThreads.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
