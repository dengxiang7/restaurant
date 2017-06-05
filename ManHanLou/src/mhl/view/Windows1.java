/*
 * 主界面  餐馆高层可以看到的
 * 用Container 处理组件可以很好的处理背景
 * 
 * 
 */
package mhl.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.io.*;
import java.awt.event.*;
import javax.imageio.*;
import java.util.*;
import tools.*;
import mhl.view2.*;
//import tools.imagepanel;

public class Windows1 extends JFrame implements ActionListener ,MouseListener{
	Image ic,time_bg,p1_im,p3_iamge,p3_renshi,p3_denglu;
	ImageIcon icon1,icon2,icon3,icon4,icon5;
	ImageIcon j1,j2,j3,j4,j5,j6,j7,j8,j9,j10;
	ImageIcon p2_icon1,p2_icon2;
	
	JMenuBar jb;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	JMenuItem jmt1,jmt2,jmt3,jmt4,jmt5;
	JMenuItem jmt2_1,jmt2_2,jmt2_3,jmt2_4,jmt2_5;
	JMenuItem jmt3_1,jmt3_2,jmt3_3,jmt3_4,jmt3_5,jmt3_6;
	
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;

	Container ct;
	String []message;
	
	
	//定义需要的面板
	JPanel jp1,jp2,jp3,jp4,jp5;
	
	JLabel timeNow;
	//javax.swing.Timer 可以定时的触发Action事件，我们可以利用它完成一些事件
	javax.swing.Timer t;
	
	imagepanel p1_image;
	JLabel p1_label1,p1_label2,p1_label3,p1_label4,p1_label5,p1_label6,p1_label7,p1_label8;
	
	//给p2创建JLabel
	JLabel p2_jl1,p2_jl2;
	
	//拆分窗口放p1和p4
	JSplitPane jsp;
	
	//把p3 的CardLayout定义全局变量否则切换不了
	CardLayout p3_card;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Windows1 Windows1=new Windows1();
	}
	
	//初始化菜单
	public void initmenu()
	{
		try {
			p3_iamge=ImageIO.read(new File("image/jiudian.gif"));
			p3_renshi=ImageIO.read(new File("image/renshi.jpg"));
			p3_denglu=ImageIO.read(new File("image/denglu.jpg"));
			time_bg=ImageIO.read(new File("image/time_bg.jpg"));
			ic= ImageIO.read(new File("image/cup.gif"));
			p1_im= ImageIO.read(new File("image/jp1_bg.jpg"));
			p2_icon1= new ImageIcon("image/p2_left.jpg");
			p2_icon2= new ImageIcon("image/p2_right.jpg");
			j1=new ImageIcon("image/jb1.jpg");
		    j2=new ImageIcon("image/jb2.jpg");
		    j3=new ImageIcon("image/jb3.jpg");
		    j4=new ImageIcon("image/jb4.jpg");
		    j5=new ImageIcon("image/jb5.jpg");
		    j6=new ImageIcon("image/jb6.jpg");
		    j7=new ImageIcon("image/jb7.jpg");
		    j8=new ImageIcon("image/jb8.jpg");
		    j9=new ImageIcon("image/jb9.jpg");
		    j10=new ImageIcon("image/jb10.jpg");
			icon1=new ImageIcon("image/jm1_icon1.jpg");
		    icon2=new ImageIcon("image/jm1_icon2.jpg");
		    icon3=new ImageIcon("image/jm1_icon3.jpg");
		    icon4=new ImageIcon("image/jm1_icon4.jpg");
		    icon5=new ImageIcon("image/jm1_icon5.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		jb=new JMenuBar();
		//一级菜单
		jm1=new JMenu("系统管理");
		
		//二级菜单
		jmt1=new JMenuItem("切换用户",icon1);
		jmt1.addActionListener(this);
		jmt2=new JMenuItem("切换到收款界面",icon2);
		jmt2.addActionListener(this);
		jmt3=new JMenuItem("登录管理",icon3);
		jmt4=new JMenuItem("万年历",icon4);
		jmt5=new JMenuItem("退出",icon5);
		
		jm1.add(jmt1);
		jm1.add(jmt2);
		jm1.add(jmt3);
		jm1.add(jmt4);
		jm1.add(jmt5);
		
		jm2=new JMenu("人事管理");
		//二级菜单
		jmt2_1=new JMenuItem("添加员工");
		jmt2_2=new JMenuItem("修改员工信息");
		jmt2_3=new JMenuItem("删除员工");
		jmt2_4=new JMenuItem("查询员工");
		jmt2_5=new JMenuItem("查看员工信息");
		
		jm2.add(jmt2_1);
		jm2.add(jmt2_2);
		jm2.add(jmt2_3);
		jm2.add(jmt2_4);
		jm2.add(jmt2_5);
		
		
		jm3=new JMenu("菜单服务");
		//二级菜单
		jmt3_1=new JMenuItem("预定位置");
		jmt3_2=new JMenuItem("退订位置");
		jmt3_3=new JMenuItem("点菜服务");
		jmt3_4=new JMenuItem("结账服务");
		jmt3_5=new JMenuItem("客服服务");
		jmt3_6=new JMenuItem("查账服务");
		
		jm3.add(jmt3_1);
		jm3.add(jmt3_2);
		jm3.add(jmt3_3);
		jm3.add(jmt3_4);
		jm3.add(jmt3_5);
		jm3.add(jmt3_6);
		
		jm4=new JMenu("报表统计");
		jm5=new JMenu("成本及库房");
		jm6=new JMenu("帮助");
		
		jb.add(jm1);
		jb.add(jm2);
		jb.add(jm3);
		jb.add(jm4);
		jb.add(jm5);
		jb.add(jm6);
		
		this.setJMenuBar(jb);
		
	}
	
	//初始化工具栏
	public void inittoolbar()
	{
		//工具栏
				jtb=new JToolBar();
				//设置工具栏的浮动
				jtb.setFloatable(false);
				jb1=new JButton(j1);
				jb1.addActionListener(this);
				//jb1.setIcon(j1);
				jb2=new JButton(j2);
				
			    jb2.addActionListener(this);
				jb3=new JButton(j3);
				jb4=new JButton(j4);
				jb5=new JButton(j5);
				jb6=new JButton(j6);
				jb7=new JButton(j7);
				jb8=new JButton(j8);
				jb9=new JButton(j9);
				jb10=new JButton(j10);
				
				jtb.add(jb1);
				jtb.add(jb2);
				jtb.add(jb3);
				jtb.add(jb4);
				jtb.add(jb5);
				jtb.add(jb6);
				jtb.add(jb7);
				jtb.add(jb8);
				jtb.add(jb9);
				jtb.add(jb10);
				
	}
	
	//初始化中间四个panel
	public void initmidle()
	{
		//处理中间 p1面板
				p1_label1=new JLabel(new ImageIcon("image/label_1.gif"));
				p1_label2=new JLabel("人 事 管 理",new ImageIcon("image/label_2.jpg"),0);
				p1_label3=new JLabel("登 录 管 理",new ImageIcon("image/label_3.jpg"),0);
				p1_label4=new JLabel("菜 价 价格",new ImageIcon("image/label_4.jpg"),0);
				p1_label5=new JLabel("报 表 统 计",new ImageIcon("image/label_5.jpg"),0);
				p1_label6=new JLabel("成 本 控 制",new ImageIcon("image/label_6.jpg"),0);
				p1_label7=new JLabel("系 统 设 置",new ImageIcon("image/label_7.jpg"),0);
				p1_label8=new JLabel("动 画 帮 助",new ImageIcon("image/label_8.jpg"),0);
				
				//使用自己光标
				Cursor mycursor=new Cursor(Cursor.HAND_CURSOR);
				
				//让JLabel不可用  鼠标进入时可用  响应鼠标消息
				p1_label2.setEnabled(false);
				p1_label2.addMouseListener(this);
				p1_label2.setCursor(mycursor);
				p1_label3.setEnabled(false);
				p1_label3.addMouseListener(this);
				p1_label3.setCursor(mycursor);
				p1_label4.setEnabled(false);
				p1_label4.addMouseListener(this);
				p1_label4.setCursor(mycursor);
				p1_label5.setEnabled(false);
				p1_label5.addMouseListener(this);
				p1_label5.setCursor(mycursor);
				p1_label6.setEnabled(false);
				p1_label6.addMouseListener(this);
				p1_label6.setCursor(mycursor);
				p1_label7.setEnabled(false);
				p1_label7.addMouseListener(this);
				p1_label7.setCursor(mycursor);
				p1_label8.setEnabled(false);
				p1_label8.addMouseListener(this);
				p1_label8.setCursor(mycursor);
				
				
				jp1=new JPanel(new BorderLayout());
				this.p1_image=new imagepanel(p1_im);
				this.p1_image.setLayout(new GridLayout(8,1));
				p1_image.add(p1_label1);
				p1_image.add(p1_label2);
				p1_image.add(p1_label3);
				p1_image.add(p1_label4);
				p1_image.add(p1_label5);
				p1_image.add(p1_label6);
				p1_image.add(p1_label7);
				p1_image.add(p1_label8);
				
				jp1.add(p1_image);
				
				//处理p2,p3,p4
				jp4=new JPanel(new BorderLayout());
				jp2=new JPanel(new CardLayout());
				p2_jl1=new JLabel(p2_icon2);
				p2_jl2=new JLabel(p2_icon1);
					
				jp2.add(p2_jl1,"0");
				jp2.add(p2_jl2,"1");
				//先给p3加一个主界面面板
				imagepanel ip3_1=new imagepanel(p3_iamge);
				imagepanel ip3_2=new imagepanel(p3_renshi);
				imagepanel ip3_3=new imagepanel(p3_denglu);
				this.p3_card=new CardLayout();
				jp3=new JPanel(this.p3_card);
				jp3.add(ip3_1,"0");
				//创建empinfo
//				empinfo empinfo=new empinfo(this);
//				jp3.add(empinfo,"renshi");
//				denglu denglu=new denglu(this);
//				jp3.add(denglu,"denglu");
				
				//p2,p3加入p4
				jp4.add(jp2,"West");
				jp4.add(jp3,"Center");
				
				//做一个拆分窗口，分别存放P1,p4
				jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp1,jp4);
				
				//把边界线设为0
				jsp.setDividerSize(0);
				jsp.setOneTouchExpandable(true);
				//指定左边占多大
				jsp.setDividerLocation(200);;
				
				ct.add(jsp,BorderLayout.CENTER);
				
		
	}
	
	public Windows1(String []paras)
	{
		 ct=this.getContentPane();
		
		 this.message=paras;
		 
		//调用初始化菜单
		 initmenu();
		 
		 //调初始化工具栏
		 inittoolbar();
		
		//初始化中间panel
		 initmidle();
		
		
		//处理p5面板
		jp5=new JPanel(new BorderLayout());
		//创建Timer
		t=new Timer(1000,this);//每隔一秒触发ActionEvent
		//timeNow=new  JLabel(Calendar.getInstance().getTime().toString());
		timeNow=new  JLabel("当前时间："+Calendar.getInstance().getTime().toLocaleString()+"     ");
		//启动定时器
		t.start();
		
		imagepanel ip1=new imagepanel(time_bg);
		ip1.setLayout(new BorderLayout());
		ip1.add(timeNow,BorderLayout.EAST);
		
		
		jp5.add(ip1);
		ct.add(jp5,BorderLayout.SOUTH);
		
		

		//this.add(jtb,BorderLayout.NORTH);
		ct.add(jtb,BorderLayout.NORTH);
		
		
	
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width-300,height-80);
		this.setLocation(50,25);
		this.setIconImage(ic);
		this.setTitle("满汉楼餐饮管理系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.timeNow.setText("当前时间："+Calendar.getInstance().getTime().toLocaleString()+"     ");
		
		if(e.getSource()==this.jmt2||e.getSource()==this.jb1)
		{
			order order=new order(this.message );
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//判断用户点击那个面板
		if(e.getSource()==this.p1_label2)
		{
			empinfo empinfo=new empinfo(this);
			jp3.add(empinfo,"renshi");
			this.p3_card.show(jp3,"renshi");
		}
		if(e.getSource()==this.p1_label3)
		{
			denglu denglu=new denglu(this);
			jp3.add(denglu,"denglu");
			this.p3_card.show(jp3, "denglu");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//如果用户选中了某个操作JLabel，则这个JLabel高亮
	   if(e.getSource()==this.p1_label2)
	   {
		   this.p1_label2.setEnabled(true);
	   }
	   if(e.getSource()==this.p1_label3)
	   {
		   this.p1_label3.setEnabled(true);
	   }
	   if(e.getSource()==this.p1_label4)
	   {
		   this.p1_label4.setEnabled(true);
	   }
	   if(e.getSource()==this.p1_label5)
	   {
		   this.p1_label5.setEnabled(true);
	   }
	   if(e.getSource()==this.p1_label6)
	   {
		   this.p1_label6.setEnabled(true);
	   }
	   if(e.getSource()==this.p1_label7)
	   {
		   this.p1_label7.setEnabled(true);
	   }
	   if(e.getSource()==this.p1_label8)
	   {
		   this.p1_label8.setEnabled(true);
	   }
	  
	 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//如果用户选中了某个操作JLabel，则这个JLabel高亮
		   if(e.getSource()==this.p1_label2)
		   {
			   this.p1_label2.setEnabled(false);
		   }
		   if(e.getSource()==this.p1_label3)
		   {
			   this.p1_label3.setEnabled(false);
		   }
		   if(e.getSource()==this.p1_label4)
		   {
			   this.p1_label4.setEnabled(false);
		   }
		   if(e.getSource()==this.p1_label5)
		   {
			   this.p1_label5.setEnabled(false);
		   }
		   if(e.getSource()==this.p1_label6)
		   {
			   this.p1_label6.setEnabled(false);
		   }
		   if(e.getSource()==this.p1_label7)
		   {
			   this.p1_label7.setEnabled(false);
		   }
		   if(e.getSource()==this.p1_label8)
		   {
			   this.p1_label8.setEnabled(false);
		   }
		  
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
