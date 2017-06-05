/*
 * ��һ������ŵ�JFrame����JDialog�п���ֱ�ӷ���
 * img.setBounds(0,0,360,360)
 * this.add(img)
 * Ҳ������������
 * Container ct=this.getContentPane()
 * ct.add(img)
 */

package mhl.view;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

import mhl.model.*;
import mhl.view.*;
import mhl.view2.*;

public class login extends JDialog implements ActionListener{
	
	//�������
	JLabel jl1,jl2,jl3;
	JTextField jtf;
	JPasswordField jpw;
	JButton jb1,jb2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		login login=new login();
	}
	
	public login()
	{
		//�����
		Container ct= this.getContentPane();
		this.setLayout(null);
		
		//����backimage
		backImage img=new backImage();
		img.setBounds(0,0,360,360);
		//�����
		//Container ct= this.getContentPane();
		ct.add(img);
		
		//�������
		jl1=new JLabel("�������û���");
		jl1.setBounds(60,190,150,50);
		//����
		ct.add(jl1);
		
		jl2=new JLabel("����������");
		jl2.setBounds(60,240,150,50);
		ct.add(jl2);
		
		jtf=new JTextField(10);
		jtf.setBounds(150,205,150,25);
		ct.add(jtf);
		
		jpw=new JPasswordField();
		jpw.setBounds(150,255,150,25);
		//��������
		jpw.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpw);
		
		jb1=new JButton("��¼");
		jb1.addActionListener(this);
		jb1.setActionCommand("��¼");
		jb1.setBounds(80,300,70,25);
		ct.add(jb1);
		
		jb2=new JButton("ȡ��");
		jb2.addActionListener(this);
		jb2.setActionCommand("ȡ��");
		jb2.setBounds(200,300,70,25);
		
		ct.add(jb2);
		
		
		this.setSize(360,360);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200, height/2-150);
		this.add(img);
		//��ʹ�����¿�
		this.setUndecorated(true);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//�ڲ���������Panel ����ͼƬ
	class backImage extends JPanel{
		Image im;
		public backImage()
		{
			try {
				im=ImageIO.read(new File("image//userLogin.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public void paintComponent(Graphics g)
		{
			g.drawImage(im, 0, 0, 360,360,this);
		}
	
	}

	
	//��Ӧ�û���¼
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��¼"))
		{
			//ȡ��Ա����������
			String id=this.jtf.getText().trim();
			String pass=new String(this.jpw.getPassword());
			UserModel us=new UserModel();
			String message[]=us.checkuser(id, pass);
			if(message[0].equals("����")||message[0].equals("����"))
			{
				String []paras={message[0],message[1]};
				Windows1 w=new Windows1(paras);
			    this.dispose();
			} 
			else if(message[0].equals("����Ա"))
			{
				String []paras={message[0],message[1]};
				order order=new order(paras);
				this.dispose();
			} 
			else
			{
				//��ʾ�Ի���
				JOptionPane.showMessageDialog(this, "������û�������");
			     return;
			}
			
			
			
			
		}
		if(e.getActionCommand().equals("ȡ��"))
		{
			this.dispose();
		}
	}

	
	
}
