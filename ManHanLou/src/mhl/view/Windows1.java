/*
 * ������  �͹ݸ߲���Կ�����
 * ��Container ����������ԺܺõĴ�����
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
	
	
	//������Ҫ�����
	JPanel jp1,jp2,jp3,jp4,jp5;
	
	JLabel timeNow;
	//javax.swing.Timer ���Զ�ʱ�Ĵ���Action�¼������ǿ������������һЩ�¼�
	javax.swing.Timer t;
	
	imagepanel p1_image;
	JLabel p1_label1,p1_label2,p1_label3,p1_label4,p1_label5,p1_label6,p1_label7,p1_label8;
	
	//��p2����JLabel
	JLabel p2_jl1,p2_jl2;
	
	//��ִ��ڷ�p1��p4
	JSplitPane jsp;
	
	//��p3 ��CardLayout����ȫ�ֱ��������л�����
	CardLayout p3_card;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Windows1 Windows1=new Windows1();
	}
	
	//��ʼ���˵�
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
		//һ���˵�
		jm1=new JMenu("ϵͳ����");
		
		//�����˵�
		jmt1=new JMenuItem("�л��û�",icon1);
		jmt1.addActionListener(this);
		jmt2=new JMenuItem("�л����տ����",icon2);
		jmt2.addActionListener(this);
		jmt3=new JMenuItem("��¼����",icon3);
		jmt4=new JMenuItem("������",icon4);
		jmt5=new JMenuItem("�˳�",icon5);
		
		jm1.add(jmt1);
		jm1.add(jmt2);
		jm1.add(jmt3);
		jm1.add(jmt4);
		jm1.add(jmt5);
		
		jm2=new JMenu("���¹���");
		//�����˵�
		jmt2_1=new JMenuItem("���Ա��");
		jmt2_2=new JMenuItem("�޸�Ա����Ϣ");
		jmt2_3=new JMenuItem("ɾ��Ա��");
		jmt2_4=new JMenuItem("��ѯԱ��");
		jmt2_5=new JMenuItem("�鿴Ա����Ϣ");
		
		jm2.add(jmt2_1);
		jm2.add(jmt2_2);
		jm2.add(jmt2_3);
		jm2.add(jmt2_4);
		jm2.add(jmt2_5);
		
		
		jm3=new JMenu("�˵�����");
		//�����˵�
		jmt3_1=new JMenuItem("Ԥ��λ��");
		jmt3_2=new JMenuItem("�˶�λ��");
		jmt3_3=new JMenuItem("��˷���");
		jmt3_4=new JMenuItem("���˷���");
		jmt3_5=new JMenuItem("�ͷ�����");
		jmt3_6=new JMenuItem("���˷���");
		
		jm3.add(jmt3_1);
		jm3.add(jmt3_2);
		jm3.add(jmt3_3);
		jm3.add(jmt3_4);
		jm3.add(jmt3_5);
		jm3.add(jmt3_6);
		
		jm4=new JMenu("����ͳ��");
		jm5=new JMenu("�ɱ����ⷿ");
		jm6=new JMenu("����");
		
		jb.add(jm1);
		jb.add(jm2);
		jb.add(jm3);
		jb.add(jm4);
		jb.add(jm5);
		jb.add(jm6);
		
		this.setJMenuBar(jb);
		
	}
	
	//��ʼ��������
	public void inittoolbar()
	{
		//������
				jtb=new JToolBar();
				//���ù������ĸ���
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
	
	//��ʼ���м��ĸ�panel
	public void initmidle()
	{
		//�����м� p1���
				p1_label1=new JLabel(new ImageIcon("image/label_1.gif"));
				p1_label2=new JLabel("�� �� �� ��",new ImageIcon("image/label_2.jpg"),0);
				p1_label3=new JLabel("�� ¼ �� ��",new ImageIcon("image/label_3.jpg"),0);
				p1_label4=new JLabel("�� �� �۸�",new ImageIcon("image/label_4.jpg"),0);
				p1_label5=new JLabel("�� �� ͳ ��",new ImageIcon("image/label_5.jpg"),0);
				p1_label6=new JLabel("�� �� �� ��",new ImageIcon("image/label_6.jpg"),0);
				p1_label7=new JLabel("ϵ ͳ �� ��",new ImageIcon("image/label_7.jpg"),0);
				p1_label8=new JLabel("�� �� �� ��",new ImageIcon("image/label_8.jpg"),0);
				
				//ʹ���Լ����
				Cursor mycursor=new Cursor(Cursor.HAND_CURSOR);
				
				//��JLabel������  ������ʱ����  ��Ӧ�����Ϣ
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
				
				//����p2,p3,p4
				jp4=new JPanel(new BorderLayout());
				jp2=new JPanel(new CardLayout());
				p2_jl1=new JLabel(p2_icon2);
				p2_jl2=new JLabel(p2_icon1);
					
				jp2.add(p2_jl1,"0");
				jp2.add(p2_jl2,"1");
				//�ȸ�p3��һ�����������
				imagepanel ip3_1=new imagepanel(p3_iamge);
				imagepanel ip3_2=new imagepanel(p3_renshi);
				imagepanel ip3_3=new imagepanel(p3_denglu);
				this.p3_card=new CardLayout();
				jp3=new JPanel(this.p3_card);
				jp3.add(ip3_1,"0");
				//����empinfo
//				empinfo empinfo=new empinfo(this);
//				jp3.add(empinfo,"renshi");
//				denglu denglu=new denglu(this);
//				jp3.add(denglu,"denglu");
				
				//p2,p3����p4
				jp4.add(jp2,"West");
				jp4.add(jp3,"Center");
				
				//��һ����ִ��ڣ��ֱ���P1,p4
				jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp1,jp4);
				
				//�ѱ߽�����Ϊ0
				jsp.setDividerSize(0);
				jsp.setOneTouchExpandable(true);
				//ָ�����ռ���
				jsp.setDividerLocation(200);;
				
				ct.add(jsp,BorderLayout.CENTER);
				
		
	}
	
	public Windows1(String []paras)
	{
		 ct=this.getContentPane();
		
		 this.message=paras;
		 
		//���ó�ʼ���˵�
		 initmenu();
		 
		 //����ʼ��������
		 inittoolbar();
		
		//��ʼ���м�panel
		 initmidle();
		
		
		//����p5���
		jp5=new JPanel(new BorderLayout());
		//����Timer
		t=new Timer(1000,this);//ÿ��һ�봥��ActionEvent
		//timeNow=new  JLabel(Calendar.getInstance().getTime().toString());
		timeNow=new  JLabel("��ǰʱ�䣺"+Calendar.getInstance().getTime().toLocaleString()+"     ");
		//������ʱ��
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
		this.setTitle("����¥��������ϵͳ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.timeNow.setText("��ǰʱ�䣺"+Calendar.getInstance().getTime().toLocaleString()+"     ");
		
		if(e.getSource()==this.jmt2||e.getSource()==this.jb1)
		{
			order order=new order(this.message );
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//�ж��û�����Ǹ����
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
		//����û�ѡ����ĳ������JLabel�������JLabel����
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
		//����û�ѡ����ĳ������JLabel�������JLabel����
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
