/*
 * 点餐界面
 * 
 */

package mhl.view2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mhl.db.*;
import mhl.model.*;
import java.util.*;

public class DianCan extends JDialog implements ActionListener{
	
	JPanel jp,jp1,jp2;
	JTextArea jl;
	JScrollPane jsp;
	JComboBox jcb;
	JButton jb1,jb2,jb3;
	int id1;
	orderModel o;
	boolean b=false;
	//String []menu;
	
	public void init()
	{
		String sql="select * from menu where 1=?";
		String []paras={"1"};
		o=new orderModel();
		Vector<Vector> s=new Vector<Vector>();
		s=o.query(sql, paras);
		String []menu=new String[s.size()];
		for(int i=0;i<s.size();i++)
		{	
			menu[i]=s.get(i).get(1).toString();
	    }
		jp=new JPanel(new GridLayout(2,1));
		jp1=new JPanel();
		jp2=new JPanel();
		
		jl=new JTextArea();
		String sql1="select * from dish where deskid=?";
		String []paras1={String.valueOf(id1)};
		Vector<Vector> e=new Vector<Vector>();
		e=o.query(sql1, paras1);
		String []menu1=new String[e.size()];
		for(int i=0;i<e.size();i++)
		{	
			jl.append(e.get(i).get(1).toString()+"\n");
		}
		jsp=new JScrollPane(jl);
		jcb=new JComboBox(menu);
		jp1.add(jcb);
		jb1=new JButton("添加");
		jb1.addActionListener( this);
		jb2=new JButton("取消");
		jb2.addActionListener( this);
		jb3=new JButton ("确定");
	    jb3.addActionListener(this);
		jp2.add(jb1);
		jp2.add(jb3);
		jp2.add(jb2);
		jp.add(jp1);
		jp.add(jp2);
		
		this.setLayout(new BorderLayout());
		
		this.add(jsp,BorderLayout.CENTER);
		this.add(jp,BorderLayout.SOUTH );
		
		this.setLocation(500,100);
		this.setSize(300,300);
	    this.setVisible(true);
		
	}
	
	public boolean date()
	{
		String []line=jl.getText().split("\n");
		String sql="insert into dish values(?,?)";
		String sql1="delete from dish where deskid=?";
		String []paras1={String.valueOf(id1)};
		
		o=new orderModel();
		o.update(sql1, paras1);
		for(int i=0;i<jl.getLineCount()-1;i++)
		{
		String []paras={String.valueOf(id1),line[i]};
		o.update(sql, paras);
		}
		
		
		
		return b;
	}
	
	
	public  DianCan(JFrame ower,String title,boolean model,int id)
	{
		
		
		super(ower,title,model);
		this.id1=id+1;
		init();
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.jb1){
			//jcb.getSelectedItem();
			jl.append(jcb.getSelectedItem()+"\n");
		}
		if(e.getSource()==this.jb3)
		{
			
			b=true;
			this.dispose();
		}
		
		if(e.getSource()==this.jb2)
		{
			this.dispose();
		}
		
	}

}
