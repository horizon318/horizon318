package InetAddressDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class demo1 {
	
	public static void main(String[] args) {
		InetAddress host=null;
		try {
			host=InetAddress.getLocalHost();
			System.out.println(host);
			InetAddress hostbaidu = InetAddress.getByName("www.baidu.com");
			System.out.println(hostbaidu);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
