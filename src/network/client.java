package network;

import java.io.*;
import java.net.*;

public class client {

	
	public static void main(String []args) throws UnknownHostException, IOException
	{
		client client1=new client();
	}
	client() throws UnknownHostException, IOException
	{
		Socket socket=new Socket("127.0.0.1",10000);//创建端口，指定服务器端口
		PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
		pw.println("---客户端---");
		InputStreamReader isr=new InputStreamReader(socket.getInputStream());
        BufferedReader br=new BufferedReader(isr);
        String back=br.readLine();
        System.out.println(back);		
		
	}
	
}
