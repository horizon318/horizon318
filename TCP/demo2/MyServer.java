package demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket=null;
		InputStream in=null;
		ObjectInputStream ois=null;
		try {
			 serverSocket=new ServerSocket(8884);;
			
			 socket=serverSocket.accept();
			in=socket.getInputStream();
			 ois=new  ObjectInputStream(in);
			try {
				Student student=(Student) ois.readObject();
				System.out.println(student);
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			socket.shutdownInput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			
				try {
					if(ois!=null)ois.close();
					if (in!=null) {
					in.close();
					}
					if(socket!=null) {
						socket.close();
					}
					if (serverSocket!=null) {
						serverSocket.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		
		
	}
}
