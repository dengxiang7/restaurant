/*
 * 点餐界面
 */
package mhl.view2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mhl.model.*;
import mhl.view.Windows1;
import tools.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.Timer;
import javax.swing.border.*;

public class order extends JFrame implements ActionListener ,MouseListener{

	//定义组件
	JMenuBar jmb;
	JMenu jm1,jm2,jm3;
	JMenuItem jmt1_1,jmt1_2,jmt2_1,jmt3_1;
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5;
	
	Image ic,time,orderI,manageI,deskI;
	ImageIcon jt1,jt2,jt3,jt4,jt5;
	
	imagepanel timep,order,manage,desk;
	JPanel jp;
	JLabel jtime;
	
	dengluModel d;
	String []paras;
	
	Timer t;
	
	Container ct;
	
	int deskid=-1,status=0;
	
	orderModel o=new orderModel();
	
	int width;
	int height;
	
	JLabel ji,jemp,position;
	ImageIcon jI;
	JButton BookTable,ExitTable,BookDish,EndBill;
	
    ImageIcon []desktwoblue=new ImageIcon[10];
    ImageIcon []desktwoyellow=new ImageIcon[10];
    ImageIcon []desktwored=new ImageIcon[10];
    JLabel []desko=new JLabel[22];
    ImageIcon []deskfourblue=new ImageIcon[10];
    ImageIcon []deskfouryellow=new ImageIcon[10];
    ImageIcon []deskfourred=new ImageIcon[10];
    //JLabel []deskfourb=new JLabel[10];
    ImageIcon []desksixblue=new ImageIcon[5];
    ImageIcon []desksixyellow=new ImageIcon[5];
    ImageIcon []desksixred=new ImageIcon[5];
    //JLabel []desksixb=new JLabel[5];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s[]={"收银员","王勇"};
		//order order=new order(s);
	}

	//图片获取
	public void image()
	{
		try {
			ic=ImageIO.read(new File("desk/icon/cup.gif"));
			time=ImageIO.read(new File ("desk/icon/time_bg.jpg"));
			orderI=ImageIO.read(new File("desk/icon/orderindex.jpg"));
			manageI=ImageIO.read(new File("desk/icon/manage.jpg"));
			deskI=ImageIO.read(new File("desk/icon/desk.jpg"));
			jI=new ImageIcon("desk/icon/black.png");
			jt1=new ImageIcon("desk/icon/hr.png");
			jt2=new ImageIcon("desk/icon/info.jpg");
			jt3=new ImageIcon("desk/icon/login.jpg");
			jt4=new ImageIcon("desk/icon/love.png");
			jt5=new ImageIcon("desk/icon/uDisk.jpg");
			
			
		
			for(int i=0;i<10;i++)
			{
				String []pb=new String[10];
				String []py=new String[10];
				String []pr=new String[10];
			    pb[i]="desk/two/blue/"+ (i+1) +"桌面组合.png";
			    py[i]="desk/two/yellow/"+ (i+1) +"桌面组合.png";
			    pr[i]="desk/two/red/"+ (i+1) +"桌面组合.png";
			    //System.out.println(p[i]);
				desktwoblue[i]=new ImageIcon(pb[i]);
				desktwoyellow[i]=new ImageIcon(py[i]);
				desktwored[i]=new ImageIcon(pr[i]);
			}	
			for(int i=11;i<21;i++)
			{
				String []pb=new String[10];
				String []py=new String[10];
				String []pr=new String[10];
			    pb[i-11]="desk/four/blue/"+ (i) +"桌面组合.png";
			    py[i-11]="desk/four/yellow/"+ (i) +"桌面组合.png";
			    pr[i-11]="desk/four/red/"+ (i) +"桌面组合.png";
			    //System.out.println(p[i]);
				deskfourblue[i-11]=new ImageIcon(pb[i-11]);
				deskfouryellow[i-11]=new ImageIcon(py[i-11]);
				deskfourred[i-11]=new ImageIcon(pr[i-11]);
			}	
			
			for(int i=21;i<25;i++)
			{
				String []pb=new String[10];
				String []py=new String[10];
				String []pr=new String[10];
			    pb[i-21]="desk/six/blue/"+ (i) +"桌面组合.png";
			    py[i-21]="desk/six/yellow/"+ (i) +"桌面组合.png";
			    pr[i-21]="desk/six/red/"+ (i) +"桌面组合.png";
			    //System.out.println(p[i]);
				desksixblue[i-21]=new ImageIcon(pb[i-21]);
				desksixyellow[i-21]=new ImageIcon(py[i-21]);
				desksixred[i-21]=new ImageIcon(pr[i-21]);
			}	
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//初始化界面
	public void init()
	{
		ct=this.getContentPane();
		
		jmb=new JMenuBar();
		jm1=new JMenu("  系统 ");
		jm2=new JMenu("  服务 ");
		jm3=new JMenu("  帮组 ");
		
		//二级菜单
		jmt1_1=new JMenuItem("切换界面");
		jmt1_1.addActionListener(this);
		jmt1_2=new JMenuItem("切换用户");
		jmt2_1=new JMenuItem("点餐");
		jmt3_1=new JMenuItem("帮助");
		
		jm1.add(jmt1_1);
		jm1.add(jmt1_2);
		jm2.add(jmt2_1);
		jm3.add(jmt3_1);
		
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		
		
		inittools();
		initmiddle();
		
		this.setLayout(new BorderLayout());
		
		this.setJMenuBar(jmb);
		ct.add(jtb, BorderLayout.NORTH);
		ct.add(timep,BorderLayout.SOUTH);
		ct.add(jp,BorderLayout.CENTER );
		
		width=Toolkit.getDefaultToolkit().getScreenSize().width-300;
		height=Toolkit.getDefaultToolkit().getScreenSize().height-80;
		this.setSize(width,height);
		this.setLocation(50,25);
		this.setTitle("点餐界面");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(ic);
		this.setVisible(true);
		
		
		
	}
	
	//初始化中间panel
	public void initmiddle()
	{
		
		jp=new JPanel();
		jp.setLayout(null);
		jp.setBounds(0, 0, 1050, 570);
		
		
		this.order=new imagepanel(orderI);
		order.setBounds(0, 0, 770, 570);

		
		this.manage=new imagepanel(manageI);
		manage.setBounds(770, 0, 300, 570);
		ji=new JLabel(jI);
	    ji.setBounds(800, 90, 200, 80);
	    
	    
		//System.out.println(paras[1]);
		jemp=new JLabel("当前用户：  "+paras[1]+"      ");
		jemp.setBounds(790, 200, 200, 50);
		
		position =new JLabel("职        位：   "+paras[0]+"     ");
		position.setBounds(790, 240, 200, 50);
		
		this.BookTable=new JButton("预定");
		BookTable.setBounds(820,500,70,30);
		BookTable.addActionListener(this);
		BookTable.setActionCommand("预定");
		this.ExitTable=new JButton("退订");
		ExitTable.setBounds(930, 500, 70, 30);
		ExitTable.addActionListener(this);
		ExitTable.setActionCommand("退订");
		this.BookDish=new JButton("点餐");
		BookDish.setBounds(820, 550, 70, 30);
		BookDish.addActionListener(this);
		BookDish.setActionCommand("点餐");
		this.EndBill=new JButton("结账");
		EndBill.setBounds(930, 550, 70, 30);
		EndBill.addActionListener(this);
		EndBill.setActionCommand("结账");
		
		
	   
		
		
		for(int i=0;i<5;i++)
		{
			 String sql="select dstatus from deskstatus where deskid=?";
		     String []paras={String.valueOf(i+1)};
		     Vector<Vector> click=o.query(sql, paras);
		    // System.out.println(paras[0]);
			if(click.get(0).get(0).equals("0"))
			{
				
			desko[i]=new JLabel(desktwoblue[i]);
			}
			if(click.get(0).get(0).equals("1"))
			{
			desko[i]=new JLabel(desktwoyellow[i]);
			}
			if(click.get(0).get(0).equals("2"))
			{
			desko[i]=new JLabel(desktwored[i]);
			}
			desko[i].setBounds(170+i*120,200,100,50);
			desko[i].addMouseListener(this);
		}
		
		for(int i=5;i<10;i++)
		{
			 String sql="select dstatus from deskstatus where deskid=?";
		     String []paras={String.valueOf(i+1)};
		     Vector<Vector> click=o.query(sql, paras);
			if(click.get(0).get(0).equals("0"))
			{
			desko[i]=new JLabel(desktwoblue[i]);
			}
			if(click.get(0).get(0).equals("1"))
			{
			desko[i]=new JLabel(desktwoyellow[i]);
			}
			if(click.get(0).get(0).equals("2"))
			{
			desko[i]=new JLabel(desktwored[i]);
			}
			//desko[i]=new JLabel(desktwoblue[i]);
			desko[i].setBounds(660,260+(i-5)*70,100,50);
			desko[i].addMouseListener(this);
		}
		
		for(int i=10;i<14;i++)
		{
			 String sql="select dstatus from deskstatus where deskid=?";
		     String []paras={String.valueOf(i+1)};
		     Vector<Vector> click=o.query(sql, paras);
			if(click.get(0).get(0).equals("0"))
			{
			desko[i]=new JLabel(deskfourblue[i-10]);
			}
			if(click.get(0).get(0).equals("1"))
			{
			desko[i]=new JLabel(deskfouryellow[i-10]);
			}
			if(click.get(0).get(0).equals("2"))
			{
			desko[i]=new JLabel(deskfourred[i-10]);
			}
			//desko[i]=new JLabel(deskfourblue[i-10]);
			desko[i].setBounds(170+(i-10)*120,300,120,50);
			desko[i].addMouseListener(this);
		}
		for(int i=14;i<18;i++)
		{
			 String sql="select dstatus from deskstatus where deskid=?";
		     String []paras={String.valueOf(i+1)};
		     Vector<Vector> click=o.query(sql, paras);
			if(click.get(0).get(0).equals("0"))
			{
			desko[i]=new JLabel(deskfourblue[i-10]);
			}
			if(click.get(0).get(0).equals("1"))
			{
			desko[i]=new JLabel(deskfouryellow[i-10]);
			}
			if(click.get(0).get(0).equals("2"))
			{
			desko[i]=new JLabel(deskfourred[i-10]);
			}
			//desko[i]=new JLabel(deskfourblue[i-10]);
			desko[i].setBounds(170+(i-14)*120,400,120,50);
			desko[i].addMouseListener(this);
		}
		for(int i=18;i<22;i++)
		{
			 String sql="select dstatus from deskstatus where deskid=?";
		     String []paras={String.valueOf(i+3)};
		     Vector<Vector> click=o.query(sql, paras);
			if(click.get(0).get(0).equals("0"))
			{
			desko[i]=new JLabel(desksixblue[i-18]);
			}
			if(click.get(0).get(0).equals("1"))
			{
			desko[i]=new JLabel(desksixyellow[i-18]);
			}
			if(click.get(0).get(0).equals("2"))
			{
			desko[i]=new JLabel(desksixred[i-18]);
			}
			//desko[i]=new JLabel(desksixblue[i-18]);
			desko[i].setBounds(170+(i-18)*120,500,120,60);
			desko[i].addMouseListener(this);
		}
		
		Cursor my=new Cursor(Cursor.HAND_CURSOR);
		for(int i=0;i<22;i++)
		{
			desko[i].setCursor(my);
		}
		
		jp.add(order);
		jp.add(manage);
		ct.add(ji);
		ct.add(jemp);
		ct.add(position);
		ct.add(BookTable);
		ct.add(ExitTable);
		ct.add(BookDish);
		ct.add(EndBill);
		for(int i=0;i<22;i++)
		{
			ct.add(desko[i]);
		}
		
	}
	
	//初始化工具条和状态栏
	public void inittools()
	{
		jtb=new JToolBar();
		
		jb1=new JButton(jt1);
		jb1.addActionListener(this);
		jb2=new JButton(jt3);
		jb3=new JButton(jt4);
		jb4=new JButton(jt5);
		jb5=new JButton(jt2);
		
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		
		jtb.setFloatable(false);
		
		timep=new imagepanel(time);
		timep.setLayout(new BorderLayout());
		t=new Timer(1000,this);
	    jtime=new JLabel("当前时间    "+Calendar.getInstance().getTime().toLocaleString()+"          ");
		timep.add(jtime,BorderLayout.EAST);
		t.start();
	}
	
	
	public order(String []paras)
	{
		this.paras=paras;
		image();
		init();
		this.paras=paras;
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.jtime.setText("当前时间    "+Calendar.getInstance().getTime().toLocaleString()+"          ");
		
		if(e.getSource()==this.jmt1_1||e.getSource()==this.jb1)
		{
			if(paras[0].equals("经理")||paras[0].equals("主管"))
			{
			Windows1 w=new Windows1(paras);
			}
		}
	
		if(e.getSource()==this.BookTable)
		{
			if(status==2||status==1)
			{
				JOptionPane.showMessageDialog(this, "已使用");
				return;
			}
			else{
				
				 BookTablePanel BookTablePanel=new BookTablePanel(this,"预定",true,deskid);
			if(BookTablePanel.b)
			{	 
			   o=new orderModel();
		       String sql="update deskstatus set dstatus=? where deskid=?";
		       if(deskid<10 )
		       {
	             String []paras={"1",String.valueOf(deskid+1)};
	             // desko[deskid]=new JLabel(deskfouryellow[deskid-10]);
	               desko[deskid].setIcon(desktwoyellow[deskid]);
	             o.update(sql, paras);
	             status=1;
		      }
		     if(deskid>9&&deskid<18  )
		     {
			  String []paras={"1",String.valueOf(deskid+1)};
			  desko[deskid].setIcon(deskfouryellow[deskid-10]);
			  o.update(sql, paras);
			  status=1;
		     }
		    if(deskid>17 && deskid<22  )
		     {
			  String []paras={"1",String.valueOf(deskid+3)};
			  desko[deskid].setIcon(desksixyellow[deskid-18]);
			  o.update(sql, paras);
			  status=1;
		    }
	       this.desko[deskid].setBorder(null);
	       deskid=0;
			}
		}
		}
		
		if(e.getSource()==this.ExitTable)
		{
			if(status==2)
			{
				JOptionPane.showMessageDialog(this, "正在用餐");
				return;
			}
			else
				if(deskid==-1)
				{
					JOptionPane.showMessageDialog(this, "请选择餐桌");
					return;
				}
				else
			{
			
			o=new orderModel();
			String sql3="delete from bookp where deskid=?";
			String []paras3={String.valueOf(deskid+1)};
			o.update(sql3, paras3);
			
		  String sql="update deskstatus set dstatus=? where deskid=?";
		  if(deskid<10)
		  {
	      String []paras={"0",String.valueOf(deskid+1)};
	     // desko[deskid]=new JLabel(deskfouryellow[deskid-10]);
	      desko[deskid].setIcon(desktwoblue[deskid]);
	      o.update(sql, paras);
	      status=0;
		  }
		  if(deskid>9&&deskid<18)
		  {
			  String []paras={"0",String.valueOf(deskid+1)};
			  desko[deskid].setIcon(deskfourblue[deskid-10]);
			  o.update(sql, paras);
			  status=0;
		  }
		  if(deskid>17 && deskid<22)
		  {
			  String []paras={"0",String.valueOf(deskid+3)};
			  desko[deskid].setIcon(desksixblue[deskid-18]);
			  o.update(sql, paras);
			  status=0;
		  }
		  String sql1="delete from bookp where deskid=?";
		  String []paras1={String.valueOf(deskid+1)};
		  o.update(sql1, paras1);
	      this.desko[deskid].setBorder(null);
	      deskid=0;
		}
		
		}
		
		if(e.getSource()==this.EndBill)
		{
			if(deskid==-1)
			{
				JOptionPane.showMessageDialog(this, "请选择餐桌");
				return;
			}
			else{
			EndBillPane E=new EndBillPane(this,"结账",true,deskid);
			if(E.date())
			{
			o=new orderModel();
		  String sql="update deskstatus set dstatus=? where deskid=?";
		  if(deskid<10)
		  {
	      String []paras={"0",String.valueOf(deskid+1)};
	     // desko[deskid]=new JLabel(deskfouryellow[deskid-10]);
	      desko[deskid].setIcon(desktwoblue[deskid]);
	      o.update(sql, paras);
	      status=0;
		  }
		  if(deskid>9&&deskid<18)
		  {
			  String []paras={"0",String.valueOf(deskid+1)};
			  desko[deskid].setIcon(deskfourblue[deskid-10]);
			  o.update(sql, paras);
			  status=0;
		  }
		  if(deskid>17 && deskid<22)
		  {
			  String []paras={"0",String.valueOf(deskid+3)};
			  desko[deskid].setIcon(desksixblue[deskid-18]);
			  o.update(sql, paras);
			  status=0;
		  }
	      this.desko[deskid].setBorder(null);
	      deskid=0;
			}
			}
		}
		
		
		if(e.getSource()==this.BookDish)
		{
			DianCan DianCan=new DianCan(this,"点餐",true,deskid);
			
			if(DianCan.date())
			{		
			o=new orderModel();
		  String sql="update deskstatus set dstatus=? where deskid=?";
		  if(deskid<10)
		  {
	      String []paras={"2",String.valueOf(deskid+1)};
	     // desko[deskid]=new JLabel(deskfouryellow[deskid-10]);
	      desko[deskid].setIcon(desktwored[deskid]);
	      o.update(sql, paras);
	      status=2;
		  }
		  if(deskid>9&&deskid<18)
		  {
			  String []paras={"2",String.valueOf(deskid+1)};
			  desko[deskid].setIcon(deskfourred[deskid-10]);
			  o.update(sql, paras);
			  status=2;
		  }
		  if(deskid>17 && deskid<22)
		  {
			  String []paras={"2",String.valueOf(deskid+3)};
			  desko[deskid].setIcon(desksixred[deskid-18]);
			  o.update(sql, paras);
			  status=2;
		  }
	      this.desko[deskid].setBorder(null);
	      deskid=0;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
		for(int i=0;i<22;i++)
		{
			String sql="select dstatus from deskstatus where deskid=?";
		     String []paras={String.valueOf(i+1)};
		     Vector<Vector> click=o.query(sql, paras);
			
			this.desko[i].setBorder(null);
			if(e.getSource()==this.desko[i])
			{
				desko[i].setBorder(new BevelBorder(BevelBorder.LOWERED));
				deskid=i;
				status= Integer.valueOf((String) click.get(0).get(0));
			}
			
		}
		
	
//		orderModel o=new orderModel();
//		String sql="select clicked ,deskid from deskstatus where 1=?";
//		String []paras={"1"};
//		String click[]=o.query(sql, paras);
//		int flag=0;
//		
//		for(int i=0;i<click.length;i++)
//		{
//			if(click[i].equals("1"))
//			{
//				flag++;
//			}
//		}
//   if(flag==0)
//    {
//		for(int i=0;i<click.length;i++)
//		{	
//			if(click[i].equals("0"))
//			{
//				//String f=(String) ((Vector)click.get(i)).get(1);
//				int id=Integer.valueOf(click[i+1]);
//				if(e.getSource()==this.desko[id])
//				{
//					this.desko[i].setBorder(new BevelBorder(BevelBorder.LOWERED));
//					String sql1="update deskstatus set clicked=? where deskid=?";
//					String []paras1={"1",click[i+1]};
//					o.update(sql1, paras1);
//					flag++;
//				}
//			}
//		}
//    }	
		

		
		
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
