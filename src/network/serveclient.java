package network;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.ActionListener;


public class serveclient extends JFrame implements ActionListener{
     
	JTextArea  jta=null;
	JButton  button1=null;
	JTextField jtf=null;
	JPanel panel=null;
	JScrollPane jsp=null;//gui
	
	PrintWriter pw=null;//net writer
	
	
	public static void main(String []args) throws UnknownHostException, IOException
	{
		serveclient client1=new serveclient();
	}
	
	
	serveclient() throws UnknownHostException, IOException
	{
		
		
		
		jta=new JTextArea();
		button1=new JButton("send");
		button1.addActionListener(this);
		
		jtf=new JTextField(30);
		panel=new JPanel();
		jsp=new JScrollPane(jta);
		
		panel.add(jtf);  panel.add(button1);
       
		this.add(jsp);
		this.add(panel,BorderLayout.SOUTH);
		
		this.setSize(500, 500);
		this.setLocation(200,200);
		this.setTitle("�ͻ���");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		Socket socket=new Socket("39.101.195.249",9999);//�����˿ڣ�ָ���������˿�
		
		pw=new PrintWriter(socket.getOutputStream(),true);

		InputStreamReader isr=new InputStreamReader(socket.getInputStream());
        BufferedReader br=new BufferedReader(isr);

		InputStreamReader isr1=new InputStreamReader(System.in);
        BufferedReader br1=new BufferedReader(isr1);
        
        
        while(true)
        {
        	
        	String message=br.readLine();

        	//System.out.println("---"+message);
			jta.append("����������˵��\n");
			jta.append("---"+message+"\n");

        	

        }
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==button1)
		{
			String message1=jtf.getText();
			jta.append("��˵��"+message1+"\n");
			pw.println(message1);
			jtf.setText("");
		}
		
	}
}
