package demo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Myclient2 {
	public static void main(String[] args) {
		Socket socket=null;
		OutputStream out=null;
		ObjectOutputStream oos=null;
		InputStream in=null;
		BufferedReader reader=null;
		try {
			 socket=new Socket("localhost",8888);
			Student student =new Student(1002,"zss",43);
			 out=socket.getOutputStream();
			 oos=new ObjectOutputStream(out);
			oos.writeObject(student);
			socket.shutdownOutput();
			in=socket.getInputStream();
			reader= new BufferedReader(new InputStreamReader(in));
			String info=null;
			while((info=reader.readLine())!=null) {
				System.out.println(info);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
				try {
					if (reader!=null) {
						reader.close();
					}
					if (in!=null) {
						in.close();
					}
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
