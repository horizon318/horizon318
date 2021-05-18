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
            System.out.println("����������");
            //׼����ϣ����Լ����ͻ�������
            socket=serverSocket.accept();
            System.out.println("�ͻ������ӳɹ�");//һֱ������ֱ���пͻ�������
            //ͨ��socket����inputStream/outputStream(׼����������)
            in=socket.getInputStream();
            //�����������ַ������ֽ���-ת����-�ַ�����
            reader=new BufferedReader(new InputStreamReader(in));
            String info =null;
            while((info=reader.readLine())!=null){
                System.out.println("IM am server ,���ܵĿͻ��������ǣ�"+info);
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
