/*
 * 显示登录人员管理
 */
package mhl.view;

import java.awt.*;
import javax.swing.*;
import mhl.model.*;
import java.awt.event.*;
import mhl.db.*;

public class denglu extends JPanel implements ActionListener{

	JLabel jl1,jl2;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4;
	
	JPanel jp1,jp2,jp3,jp4;
	
	JScrollPane jsp;
	JTable jta;
	dengluModel dm;
	SqlHelper sh;
	
	JFrame ower;
	
	
	
	//初始化
	public void init()
	{
		jta=new JTable();
		jsp=new JScrollPane(jta);
		dm=new dengluModel();
		String sql2="insert into denglu (empid,password) values ( (select emp.empid from emp where emp.position  in('经理','主管','收银员') "
				+ "and emp.empid not in(select denglu.empid from denglu )),?)";
		String []paras2={"0"};
		String sql3="delete from denglu where denglu.empid is null and 1=?";
		String []paras3={"1"};
		dm.updata(sql2, paras2);
		dm.updata( sql3, paras3);
		String sql="select emp.empid as 员工号,emp.name as 姓名,emp.position as 职位 ,"
				+ "denglu.password  as 密码 from emp,denglu where emp.empid=denglu.empid and 1=?";
		String []paras={"1"};
		dm.query(sql,paras);
		jta.setModel(dm);
		
		jl1=new JLabel("请输入员工号",JLabel.CENTER);
		jl2=new JLabel("当前共有"+jta.getRowCount()+"条记录",JLabel.LEFT);
		jtf=new JTextField(20);
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jb1.setActionCommand("查询");
		jb2=new JButton("删除记录");
		jb2.addActionListener(this);
		jb2.setActionCommand("删除记录");
		//jb3=new JButton("查询");
		jb4=new JButton("修改密码");
		jb4.addActionListener(this);
		jb4.setActionCommand("修改密码");
		
		jp1=new JPanel(new FlowLayout());
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp2=new JPanel(new BorderLayout());
		jp3=new JPanel(new FlowLayout());
		jp3.add(jl2,FlowLayout.LEFT);
		jp4=new JPanel(new FlowLayout());
		jp4.add(jb2);
		jp4.add(jb4);
		jp2.add(jp3,BorderLayout.WEST);
		jp2.add(jp4,BorderLayout.EAST);
		
		
		
		
		this.setLayout(new BorderLayout());
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.add(jsp,BorderLayout.CENTER);
		
		
		this.setVisible(true);
	}

	public denglu(JFrame ower)
	{
		init();
		
		this.ower=ower;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("查询"))
		{
			this.dm=new dengluModel();
//			String sql2="insert into denglu (empid,password) values('select emp.empid from emp where emp.position  in('经理','主管','收银员')"
//					+ " and emp.empid not in(select denglu.empid from denglu )',?)";
//			String []paras2={"0"};
//			dm.updata(sql2, paras2);
			
			String sql="Select emp.empid as 员工号 ,emp.name as 姓名 ,emp.position as 职位 , denglu.password as 密码 "
					+ "from emp ,denglu where emp.empid =denglu.empid and denglu.empid=?";
			String []paras={this.jtf.getText()};
			
			
			dm.query(sql, paras);
			
			this.jta.setModel(dm);
		}
		if(e.getActionCommand().equals("删除记录"))
		{
			int w=jta.getSelectedRow();
			if(w==-1)
			{
				JOptionPane.showMessageDialog(this.ower, "请选择一行");
				return;
			}
			dm=new dengluModel();
			
			String sql="delete from denglu where denglu.empid=?";
			String []paras={(String)jta.getValueAt(w, 0)};
			//dm=new dengluModel();
			dm.updata(sql, paras);
			
			String sql1="Select emp.empid as 员工号 ,emp.name as 姓名 ,emp.position as 职位 , denglu.password as 密码 "
					+ "from emp ,denglu where emp.empid =denglu.empid and 1=?";
			String []paras1={"1"};
			dm.query(sql1, paras1);
			this.jta.setModel(dm);
		}
		if(e.getActionCommand().equals("修改密码"))
		{
			int w=jta.getSelectedRow();
			if(w==-1){
				JOptionPane.showMessageDialog(this, "提示");
				return;
			}
			String []paras={(String)this.jta.getValueAt(w, 0),(String)this.jta.getValueAt(w, 3)};
		    ModifyPassword m=new ModifyPassword(this.ower,"修改密码",true,paras);
			dm=new dengluModel();
			String sql1="Select emp.empid as 员工号 ,emp.name as 姓名 ,emp.position as 职位 , denglu.password as 密码 "
					+ "from emp ,denglu where emp.empid =denglu.empid and 1=?";
			String []paras1={"1"};
			dm.query(sql1, paras1);
			this.jta.setModel(dm);
		    
		}
	}

}
