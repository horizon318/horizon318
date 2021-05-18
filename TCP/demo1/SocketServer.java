package demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream in=null;
        OutputStream out=null;
        BufferedReader reader=null;
        try {
        	
            serverSocket=new ServerSocket(8888);
            System.out.println("服务器启动");
            //准备完毕，可以监听客户端请求
            socket=serverSocket.accept();
            System.out.println("客户端连接成功");//一直阻塞，直到有客户端连接
            //通过socket生成inputStream/outputStream(准备发送数据)
            in=socket.getInputStream();
            //带缓冲区的字符流（字节流-转换流-字符流）
            reader=new BufferedReader(new InputStreamReader(in));
            String info =null;
            while((info=reader.readLine())!=null){
                System.out.println("IM am server ,接受的客户端形象是："+info);
            }
            socket.shutdownInput();
            
             out =socket.getOutputStream();
            out.write("wolcome ...client".getBytes());
            socket.shutdownOutput();
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        	
        	try {
				if(reader!=null)reader.close();
				if(out!=null)out.close();
				if(in!=null)in.close();
				if(socket!=null)socket.close();
				if(serverSocket!=null)serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }

	}
		
    
}
