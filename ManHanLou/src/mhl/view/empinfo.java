/*
 * 显示人事信息的界面
 */
package mhl.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mhl.model.*;
import mhl.db.*;

public class empinfo extends JPanel implements ActionListener{

	//定义需要组件
	JPanel jp1,jp2,jp3,jp4,jp5;
	JLabel jl1,jl3;
	JButton jb1,jb4_1,jb4_2,jb4_3,jb4_4;
	JTextField jtf1;
	
	//JTabel 
	JTable jtb;
	JScrollPane jsp;
	
	//
	Frame  ower;
	 
	
	eninfomodel en=new eninfomodel();
	
	
	//初始化界面
	public void init()
	{
		//创建组件
		//中间对齐
		jp1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		jtf1=new JTextField(20);
		jl1=new JLabel("请输入员工姓名（员工号或职位）",JLabel.CENTER);
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jb1.setActionCommand("查询");
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jb1);
		
		//处理中间人事表
		jp2=new JPanel(new BorderLayout());
		String sql="select empid as 员工号,name as 姓名,sex as 性别,position as 职位 ,marriage as 婚否 from emp where 1=?";
		String []paras={"1"};
	    en=new eninfomodel();
		en.query(sql, paras);
		jtb=new JTable(en);
		jsp=new JScrollPane(jtb);
		jp2.add(jsp);
		
		//左对齐
		jp3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jl3=new JLabel("共有"+jtb.getRowCount()+"条记录");
		jp3.add(jl3);
		//右对齐
		jp4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jb4_1=new JButton("详细信息");
		jb4_1.addActionListener(this);
		jb4_1.setActionCommand("详细信息");
		jb4_2=new JButton("添加");
		jb4_2.addActionListener(this);
		jb4_2.setActionCommand("添加");
		jb4_3=new JButton("修改");
		jb4_3.addActionListener(this);
		jb4_3.setActionCommand("修改");
		jb4_4=new JButton("删除");
		jb4_4.addActionListener(this);
		jb4_4.setActionCommand("删除");
		jp4.add(jb4_1);
		jp4.add(jb4_2);
		jp4.add(jb4_3);
		jp4.add(jb4_4);
		
		jp5=new JPanel(new BorderLayout());
		jp5.add(jp3,BorderLayout.WEST);
		jp5.add(jp4,BorderLayout.EAST);
		
		this.setLayout(new BorderLayout());
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp5,BorderLayout.SOUTH);
		this.add(jp2,BorderLayout.CENTER);
	}

	public empinfo (Frame  ower)
	{
		init();
		//this.setBackground(Color.WHITE);
		this.ower=ower;
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("查询"))
		{
			String id=jtf1.getText();
			
			String sql="select empid as 员工号,name as 姓名,sex as 性别,position as 职位 ,marriage as 婚否 from emp where empid=?";
		    String []paras={id};
		    
		  //构建    新的数据模型   并更新
		    eninfomodel o=new eninfomodel();
		    o.query(sql, paras);
		    //更新JTable
		    jtb.setModel(o);
		}
		if(e.getActionCommand().equals("详细信息"))
		{
			int w=this.jtb.getSelectedRow();
			if(w==-1)
			{
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			
			String []id={(String)jtb.getValueAt(w, 0)};
			
			//构建    新的数据模型   不更新
			
			 String sql="select * from emp where empid=?";
			 eninfomodel b=new  eninfomodel();
			 b.query(sql, id);
			//jtb.setModel(b);
			 String []shuju=new String[15];
			for (int i=0;i<15;i++)
			{
			   shuju[i]=(String)b.getValueAt(0, i);
				//System.out.println(shujun[i]);
			}
			
			empinformation emp=new empinformation(ower,"详细信息",true,shuju);
			
		}
		
		if(e.getActionCommand().equals("添加"))
		{
			addemp add=new addemp(this.ower,"添加员工",true);
			
			String sql="select empid as 员工号,name as 姓名,sex as 性别,position as 职位 ,marriage as 婚否 from emp where 1=?";
		    String []paras={"1"};
			
			//更新数据模型 并更新
			eninfomodel o=new eninfomodel();
			o.query(sql, paras);
			//更新JTable
		    jtb.setModel(o);
		}
		
		if(e.getActionCommand().equals("修改"))
		{
			int w=this.jtb.getSelectedRow();
			if(w==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			
			String []id={(String)jtb.getValueAt(w, 0)};
			String sql="select * from emp where empid=?";
			//String []paras={"id"};
			
			eninfomodel b=new eninfomodel();
			b.query(sql, id);
			 String []shuju=new String[15];
			 for(int i=0;i<15;i++)
			 {
				 shuju[i]=(String)b.getValueAt(0, i);
			 }
			 
				modify m=new modify(this.ower,"修改员工信息",true,shuju);
				
				String sql1="select empid as 员工号,name as 姓名,sex as 性别,position as 职位 ,marriage as 婚否 from emp where 1=?";
			    String []paras1={"1"};
				
				//构建新的数据模型 并更新
				eninfomodel o=new eninfomodel();
				o.query(sql1, paras1);
				this.jtb.setModel(o);
			 
		}
		
		if(e.getActionCommand().equals("删除"))
		{
			int w=this.jtb.getSelectedRow();
			if(w==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			
			String []id={(String)jtb.getValueAt(w, 0)};
			String sql="delete from emp where empid=?";
			String sql2="delete from denglu where empid=?";
			SqlHelper sh=new SqlHelper();
			sh.updata(sql2, id);
			sh.updata(sql, id);
			sh.close();
			
			String sql1="select empid as 员工号,name as 姓名,sex as 性别,position as 职位 ,marriage as 婚否 from emp where 1=?";
		    String []paras1={"1"};
			
			//构建新的数据模型 并更新
			eninfomodel o=new eninfomodel();
			o.query(sql1, paras1);
			this.jtb.setModel(o);
		}
	}
	
}
