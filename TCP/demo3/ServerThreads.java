package demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ServerThreads extends Thread {
	Socket socket;
	public ServerThreads(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		InputStream in=null;
		ObjectInputStream ois=null;
		 OutputStream out=null;
		try {
			in =socket.getInputStream();
			ois=new ObjectInputStream(in);
			Student student = null;
			
				try {
					student = (Student)ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			System.out.println(student);
			socket.shutdownInput();
		  out = socket.getOutputStream();
		  out.write("“— ’µΩ°£°£°£".getBytes());
		  socket.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if (out!=null) {
						
						out.close();
					}
					if (ois!=null) {
					ois.close();
					}
					if(in!=null)
						in.close();
					if (socket!=null) {
						socket.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
	}

}
