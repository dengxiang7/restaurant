/*
 * ��ʾ��¼��Ա����
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
	
	
	
	//��ʼ��
	public void init()
	{
		jta=new JTable();
		jsp=new JScrollPane(jta);
		dm=new dengluModel();
		String sql2="insert into denglu (empid,password) values ( (select emp.empid from emp where emp.position  in('����','����','����Ա') "
				+ "and emp.empid not in(select denglu.empid from denglu )),?)";
		String []paras2={"0"};
		String sql3="delete from denglu where denglu.empid is null and 1=?";
		String []paras3={"1"};
		dm.updata(sql2, paras2);
		dm.updata( sql3, paras3);
		String sql="select emp.empid as Ա����,emp.name as ����,emp.position as ְλ ,"
				+ "denglu.password  as ���� from emp,denglu where emp.empid=denglu.empid and 1=?";
		String []paras={"1"};
		dm.query(sql,paras);
		jta.setModel(dm);
		
		jl1=new JLabel("������Ա����",JLabel.CENTER);
		jl2=new JLabel("��ǰ����"+jta.getRowCount()+"����¼",JLabel.LEFT);
		jtf=new JTextField(20);
		jb1=new JButton("��ѯ");
		jb1.addActionListener(this);
		jb1.setActionCommand("��ѯ");
		jb2=new JButton("ɾ����¼");
		jb2.addActionListener(this);
		jb2.setActionCommand("ɾ����¼");
		//jb3=new JButton("��ѯ");
		jb4=new JButton("�޸�����");
		jb4.addActionListener(this);
		jb4.setActionCommand("�޸�����");
		
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
		if(e.getActionCommand().equals("��ѯ"))
		{
			this.dm=new dengluModel();
//			String sql2="insert into denglu (empid,password) values('select emp.empid from emp where emp.position  in('����','����','����Ա')"
//					+ " and emp.empid not in(select denglu.empid from denglu )',?)";
//			String []paras2={"0"};
//			dm.updata(sql2, paras2);
			
			String sql="Select emp.empid as Ա���� ,emp.name as ���� ,emp.position as ְλ , denglu.password as ���� "
					+ "from emp ,denglu where emp.empid =denglu.empid and denglu.empid=?";
			String []paras={this.jtf.getText()};
			
			
			dm.query(sql, paras);
			
			this.jta.setModel(dm);
		}
		if(e.getActionCommand().equals("ɾ����¼"))
		{
			int w=jta.getSelectedRow();
			if(w==-1)
			{
				JOptionPane.showMessageDialog(this.ower, "��ѡ��һ��");
				return;
			}
			dm=new dengluModel();
			
			String sql="delete from denglu where denglu.empid=?";
			String []paras={(String)jta.getValueAt(w, 0)};
			//dm=new dengluModel();
			dm.updata(sql, paras);
			
			String sql1="Select emp.empid as Ա���� ,emp.name as ���� ,emp.position as ְλ , denglu.password as ���� "
					+ "from emp ,denglu where emp.empid =denglu.empid and 1=?";
			String []paras1={"1"};
			dm.query(sql1, paras1);
			this.jta.setModel(dm);
		}
		if(e.getActionCommand().equals("�޸�����"))
		{
			int w=jta.getSelectedRow();
			if(w==-1){
				JOptionPane.showMessageDialog(this, "��ʾ");
				return;
			}
			String []paras={(String)this.jta.getValueAt(w, 0),(String)this.jta.getValueAt(w, 3)};
		    ModifyPassword m=new ModifyPassword(this.ower,"�޸�����",true,paras);
			dm=new dengluModel();
			String sql1="Select emp.empid as Ա���� ,emp.name as ���� ,emp.position as ְλ , denglu.password as ���� "
					+ "from emp ,denglu where emp.empid =denglu.empid and 1=?";
			String []paras1={"1"};
			dm.query(sql1, paras1);
			this.jta.setModel(dm);
		    
		}
	}

}
