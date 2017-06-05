/*
 * 把一个组件放到JFrame或者JDialog中可以直接放入
 * img.setBounds(0,0,360,360)
 * this.add(img)
 * 也可以这样子做
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
	
	//定义组件
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
		//放组件
		Container ct= this.getContentPane();
		this.setLayout(null);
		
		//创建backimage
		backImage img=new backImage();
		img.setBounds(0,0,360,360);
		//放组件
		//Container ct= this.getContentPane();
		ct.add(img);
		
		//创建组件
		jl1=new JLabel("请输入用户名");
		jl1.setBounds(60,190,150,50);
		//放入
		ct.add(jl1);
		
		jl2=new JLabel("请输入密码");
		jl2.setBounds(60,240,150,50);
		ct.add(jl2);
		
		jtf=new JTextField(10);
		jtf.setBounds(150,205,150,25);
		ct.add(jtf);
		
		jpw=new JPasswordField();
		jpw.setBounds(150,255,150,25);
		//设置下陷
		jpw.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpw);
		
		jb1=new JButton("登录");
		jb1.addActionListener(this);
		jb1.setActionCommand("登录");
		jb1.setBounds(80,300,70,25);
		ct.add(jb1);
		
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jb2.setActionCommand("取消");
		jb2.setBounds(200,300,70,25);
		
		ct.add(jb2);
		
		
		this.setSize(360,360);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200, height/2-150);
		this.add(img);
		//不使用上下框
		this.setUndecorated(true);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//内部类用来放Panel 处理图片
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

	
	//响应用户登录
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("登录"))
		{
			//取出员工号与密码
			String id=this.jtf.getText().trim();
			String pass=new String(this.jpw.getPassword());
			UserModel us=new UserModel();
			String message[]=us.checkuser(id, pass);
			if(message[0].equals("主管")||message[0].equals("经理"))
			{
				String []paras={message[0],message[1]};
				Windows1 w=new Windows1(paras);
			    this.dispose();
			} 
			else if(message[0].equals("收银员"))
			{
				String []paras={message[0],message[1]};
				order order=new order(paras);
				this.dispose();
			} 
			else
			{
				//提示对话框
				JOptionPane.showMessageDialog(this, "密码或用户名错误");
			     return;
			}
			
			
			
			
		}
		if(e.getActionCommand().equals("取消"))
		{
			this.dispose();
		}
	}

	
	
}
