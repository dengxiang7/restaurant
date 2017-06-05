package mhl.view2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mhl.db.*;
import mhl.model.*;
import java.util.*;

public class EndBillPane extends JDialog implements ActionListener{

	int id1;
	JTextArea jta;
	JScrollPane jsp;
	JLabel jl;
	JButton jb1,jb2;
	JPanel jp1,jp2,jp3;
	orderModel o=new orderModel();
	boolean b=false;
	
	double price=0;
	
	public  void init()
	{
		jta=new JTextArea();
		String sql1="select * from dish where deskid=?";
		String []paras1={String.valueOf(id1)};
		Vector<Vector> e=new Vector<Vector>();
		e=o.query(sql1, paras1);
		String []menu1=new String[e.size()];
		for(int i=0;i<e.size();i++)
		{	
			jta.append(e.get(i).get(1).toString()+"\n");
		}
		jsp=new JScrollPane(jta);
		
		
		String sql2="select price from menu where foodname=?";
		for(int i=0;i<e.size();i++)
		{	
		String []paras2={e.get(i).get(1).toString()};
		Vector<Vector> y=new Vector<Vector>();
		y=o.query(sql2, paras2);
		price=price+(Double.valueOf(y.get(0).get(0).toString())); 
		}
		
		jl=new JLabel(" 消费总额    ："+price);
		
		jb1=new JButton("确定");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		
		jp1=new JPanel(new GridLayout(2,1));
		jp2=new JPanel();
		jp2.add(jl);
		jp3=new JPanel();
		jp3.add(jb1);
		jp3.add(jb2);
		jp1.add(jp2);
		jp1.add(jp3);
		
		this.setLayout(new BorderLayout());
		
		this.add(jsp,BorderLayout.CENTER);
		this.add(jp1, BorderLayout.SOUTH );
		
		this.setLocation(500,100);
		this.setSize(200,300);
	    this.setVisible(true);
		
	}
	
	public boolean date()
	{
		if(b=true)
		{
		String sql="delete from dish where deskid=?";
		String []paras={String.valueOf(id1)};
		o.update(sql, paras);
		}
		return b;
	}
	
	
	public EndBillPane(JFrame ower,String title,boolean Model,int id)
	{
		super(ower,title,Model);
		this.id1=id+1;
		
		 init();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb1)
		{
			b=true;
			this.dispose();
			
		}
		if(e.getSource()==jb2)
		{
			this.dispose();
		}
	}

}
