/*
 * ��ɶ���Ա�����
 */

package mhl.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mhl.db.*;
import mhl.model.*;

public class addemp  extends JDialog implements ActionListener{

	//������Ҫ���
	JLabel []jl=new JLabel[15];
	JTextField []jtf=new JTextField[15];
	JPanel []jp=new JPanel[16];
	JButton jb1,jb2;
	
	String []paras=new String[15];
	
	//eninfomodel en=new eninfomodel();
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//addemp addemp=new addemp();
//	}

	//��ʼ�����
	public void init()
	{
		
		jl[0]=new JLabel("Ա����: ",JLabel.RIGHT);
		jl[1]=new JLabel("����:     ",JLabel.RIGHT);
		jl[2]=new JLabel("��Ƭ:     ",JLabel.RIGHT);
		jl[3]=new JLabel("�Ա�:     ",JLabel.RIGHT);
		jl[4]=new JLabel("סַ:     ",JLabel.RIGHT);
		jl[5]=new JLabel("����:     ",JLabel.RIGHT);
		jl[6]=new JLabel("���֤: ",JLabel.RIGHT);
		jl[7]=new JLabel("ѧ��:     ",JLabel.RIGHT);
		jl[8]=new JLabel("ְλ:     ",JLabel.RIGHT);
		jl[9]=new JLabel("���:     ",JLabel.RIGHT);
		jl[10]=new JLabel("������: ",JLabel.RIGHT);
		jl[11]=new JLabel("�ֻ���: ",JLabel.RIGHT);
		jl[12]=new JLabel("����:     ",JLabel.RIGHT);
		jl[13]=new JLabel("��ְʱ��:",JLabel.RIGHT);
		jl[14]=new JLabel("��ע:     ",JLabel.RIGHT);
		
		for(int i=0;i<15;i++)
		{
			jtf[i]=new JTextField(10);
			
		}
		
		for(int i=0;i<16;i++)
		{
			jp[i]=new JPanel();
		}
		JButton jb1=new JButton("ȷ��");
		jb1.addActionListener(this);
		jb1.setActionCommand("ȷ��");
		JButton jb2=new JButton("ȡ��");
		jb2.addActionListener(this);
		jb2.setActionCommand("ȡ��");
		
		this.setLayout(new GridLayout(16,2));
		
		for(int i=0;i<15;i++)
		{
			jp[i].add(jl[i]);
			jp[i].add(jtf[i]);
			this.add(jp[i]);
			
		}
		
		jp[15].add(jb1);
		jp[15].add(jb2);
		this.add(jp[15]);
		
	}
	
	//�õ�����,��������ݿ�
	public boolean getdata()
	{
		boolean b=true;
		
	  for(int i=0;i<15;i++)
	  {
		  paras[i]=jtf[i].getText();
		  //System.out.println(paras[i]);
	  }
	  
	  String sql="insert  into emp values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  SqlHelper sh=new SqlHelper();
	  if(!sh.updata(sql, paras))
	  {
		  b=false;
	  }
	  sh.close();
		return b;
	}
	public addemp(Frame ower,String title,boolean model)
	{
		super(ower,title,model);
		init();
		
		this.setLocation(500,100);
		this.setSize(300,500);
	    this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("ȷ��"))
		{
			if(getdata())
			{
				JOptionPane.showMessageDialog(this, "���ʧ��");
			
			}
			this.dispose();
		}
		
		if(e.getActionCommand().equals("ȡ��"))
		{
			this.dispose();
		}
	}

}
