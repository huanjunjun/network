package network;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;


public class serve extends JFrame implements ActionListener{
	
	//�����ȶ�����Ҫ������
	JTextArea  jta=null;
	JButton  button1=null;
	JTextField jtf=null;
	JPanel panel=null;
	JScrollPane jsp=null;//gui
	
	PrintWriter pw=null;//net writer
	
	public static void main(String [] args) throws IOException
	{
		serve nw=new serve();
	}
	
	serve() throws IOException
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
		this.setTitle("��������");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ServerSocket sersocket=new ServerSocket(9999);//���ö˿�
//		System.out.println("����������ing");
		Socket socket=sersocket.accept();//�����˿ڣ�׼�����ܿͻ���
		
		jta.setText("�ɹ����ӿͻ���\n");
		
		
		InputStreamReader isr=new InputStreamReader(socket.getInputStream());
		BufferedReader br=new BufferedReader(isr);//���ն˿���Ϣ

		InputStreamReader isr1=new InputStreamReader(System.in);
		BufferedReader br1=new BufferedReader(isr1);//���ռ�����Ϣ
		
		pw=new PrintWriter(socket.getOutputStream(),true);//��ʼ��



		while(true)
		{
//			String mymessage=br1.readLine();
//			pw.println(mymessage);
			
			String message=br.readLine();
//			System.out.println("�ͻ��˶���˵��");
//			System.out.println("---"+message+"\n");
			jta.append("�ͻ��˶���˵��\n");
			jta.append("---"+message+"\n");
			
		}
		
		
	}



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
