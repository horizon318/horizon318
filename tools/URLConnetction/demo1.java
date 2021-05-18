package URLConnetction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class demo1 {
	public static void main(String[] args) {
		URLConnection openConnection=null;
		InputStream in=null;
		OutputStream out=null;
		try {
			URL url = new URL("https://www.lanqiao.cn/courses/2198/learning/?id=45618");
			 openConnection = url.openConnection();
			 in = openConnection.getInputStream();
			 out = new FileOutputStream("d:\\163.txt");
			
			byte[] data=new byte[64];
			int len = -1;
			while((len=in.read(data))!=-1){
				out.write(data,0,len);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (out!=null) {
					out.close();
					
				}
				if (in!=null) {
					
					in.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
