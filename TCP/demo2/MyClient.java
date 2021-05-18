package demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class MyClient {
	public static void main(String[] args) {
		Socket socket=null;
		OutputStream out=null;
		ObjectOutputStream oos=null;

		try {
			 socket=new Socket("localhost",8884);
			Student student =new Student(1001,"zs",23);
			 out=socket.getOutputStream();
			 oos=new ObjectOutputStream(out);
			oos.writeObject(student);
			socket.shutdownOutput();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
				try {
					if(oos!=null)
					oos.close();
					if (out!=null) {
						out.close();
						}
						if(socket!=null) {
							socket.close();
						}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
}
