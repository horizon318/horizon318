package demo1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Send {
	public static void main(String[] args) {
		InetAddress ip = null;
		try {
			ip = InetAddress.getByName("localhost");
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DatagramSocket ds = null;
		try {
			

			String msg = "helloserver..";
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), ip, 9998);

			ds = new DatagramSocket();
			ds.send(dp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ds!=null) {
				ds.close();
			}
			
		}
	}
}
