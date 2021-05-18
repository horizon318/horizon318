package demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive {
	public static void main(String[] args) {
		byte[] data=	new byte[64];
		DatagramPacket dp=null;
		DatagramSocket ds=null;
		try {
			
			dp = new DatagramPacket(data, data.length);
			ds = new DatagramSocket(9998);
			System.out.println("已启动");
			ds.receive(dp);
			
			String receiveData = new String(dp.getData(),0,data.length);
			System.out.println("接受的数据"+receiveData);
			System.out.println("显示发送方的信息"+dp.getAddress().getHostAddress());
		}catch (SocketException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ds!=null) {
				ds.close();
			}
			
		}
	}
}
