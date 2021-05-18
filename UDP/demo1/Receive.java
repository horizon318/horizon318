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
			System.out.println("������");
			ds.receive(dp);
			
			String receiveData = new String(dp.getData(),0,data.length);
			System.out.println("���ܵ�����"+receiveData);
			System.out.println("��ʾ���ͷ�����Ϣ"+dp.getAddress().getHostAddress());
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
