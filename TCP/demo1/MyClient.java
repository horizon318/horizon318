package demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {
	  public static void main(String[] args) {
		  Socket socket=null;
		  OutputStream out=null;
		  InputStream in=null;
		  BufferedReader reader=null;
	        try {
	             socket=new Socket("169.254.1.172",8888);
	             System.out.println("服务器连接成功");
	             out=socket.getOutputStream();
	            out.write("hello server".getBytes());
	            socket.shutdownOutput();
	            in=socket.getInputStream();
	           reader=new BufferedReader(new InputStreamReader(in));
	            String info=null;
	            while ((info=reader.readLine())!=null) {
					System.out.println("I am client 接受的数据"+info);
				}
	           
	            socket.shutdownInput();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	        	try {
					if(reader!=null)reader.close();
					if(out!=null)out.close();
					if(in!=null)in.close();
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
