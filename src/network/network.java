package network;

import java.io.*;
import java.net.*;

public class network {

	public static void main(String [] args) throws IOException
	{
		network nw=new network();
	}
	
	network() throws IOException
	{
		ServerSocket sersocket=new ServerSocket(10000);//���ö˿�
		System.out.println("����������ing");
		Socket socket=sersocket.accept();//�����˿ڣ�׼�����ܿͻ���
		
		InputStreamReader isr=new InputStreamReader(socket.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		String message=br.readLine();
		System.out.println(message);//����������ӡ
		
		PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
		pw.println("---������---");
		
		
	}
	
	
}
