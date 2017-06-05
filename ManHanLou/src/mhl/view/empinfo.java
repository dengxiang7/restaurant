/*
 * ��ʾ������Ϣ�Ľ���
 */
package mhl.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mhl.model.*;
import mhl.db.*;

public class empinfo extends JPanel implements ActionListener{

	//������Ҫ���
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
	
	
	//��ʼ������
	public void init()
	{
		//�������
		//�м����
		jp1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		jtf1=new JTextField(20);
		jl1=new JLabel("������Ա��������Ա���Ż�ְλ��",JLabel.CENTER);
		jb1=new JButton("��ѯ");
		jb1.addActionListener(this);
		jb1.setActionCommand("��ѯ");
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jb1);
		
		//�����м����±�
		jp2=new JPanel(new BorderLayout());
		String sql="select empid as Ա����,name as ����,sex as �Ա�,position as ְλ ,marriage as ��� from emp where 1=?";
		String []paras={"1"};
	    en=new eninfomodel();
		en.query(sql, paras);
		jtb=new JTable(en);
		jsp=new JScrollPane(jtb);
		jp2.add(jsp);
		
		//�����
		jp3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		jl3=new JLabel("����"+jtb.getRowCount()+"����¼");
		jp3.add(jl3);
		//�Ҷ���
		jp4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jb4_1=new JButton("��ϸ��Ϣ");
		jb4_1.addActionListener(this);
		jb4_1.setActionCommand("��ϸ��Ϣ");
		jb4_2=new JButton("���");
		jb4_2.addActionListener(this);
		jb4_2.setActionCommand("���");
		jb4_3=new JButton("�޸�");
		jb4_3.addActionListener(this);
		jb4_3.setActionCommand("�޸�");
		jb4_4=new JButton("ɾ��");
		jb4_4.addActionListener(this);
		jb4_4.setActionCommand("ɾ��");
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
		if(e.getActionCommand().equals("��ѯ"))
		{
			String id=jtf1.getText();
			
			String sql="select empid as Ա����,name as ����,sex as �Ա�,position as ְλ ,marriage as ��� from emp where empid=?";
		    String []paras={id};
		    
		  //����    �µ�����ģ��   ������
		    eninfomodel o=new eninfomodel();
		    o.query(sql, paras);
		    //����JTable
		    jtb.setModel(o);
		}
		if(e.getActionCommand().equals("��ϸ��Ϣ"))
		{
			int w=this.jtb.getSelectedRow();
			if(w==-1)
			{
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			
			String []id={(String)jtb.getValueAt(w, 0)};
			
			//����    �µ�����ģ��   ������
			
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
			
			empinformation emp=new empinformation(ower,"��ϸ��Ϣ",true,shuju);
			
		}
		
		if(e.getActionCommand().equals("���"))
		{
			addemp add=new addemp(this.ower,"���Ա��",true);
			
			String sql="select empid as Ա����,name as ����,sex as �Ա�,position as ְλ ,marriage as ��� from emp where 1=?";
		    String []paras={"1"};
			
			//��������ģ�� ������
			eninfomodel o=new eninfomodel();
			o.query(sql, paras);
			//����JTable
		    jtb.setModel(o);
		}
		
		if(e.getActionCommand().equals("�޸�"))
		{
			int w=this.jtb.getSelectedRow();
			if(w==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
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
			 
				modify m=new modify(this.ower,"�޸�Ա����Ϣ",true,shuju);
				
				String sql1="select empid as Ա����,name as ����,sex as �Ա�,position as ְλ ,marriage as ��� from emp where 1=?";
			    String []paras1={"1"};
				
				//�����µ�����ģ�� ������
				eninfomodel o=new eninfomodel();
				o.query(sql1, paras1);
				this.jtb.setModel(o);
			 
		}
		
		if(e.getActionCommand().equals("ɾ��"))
		{
			int w=this.jtb.getSelectedRow();
			if(w==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			
			String []id={(String)jtb.getValueAt(w, 0)};
			String sql="delete from emp where empid=?";
			String sql2="delete from denglu where empid=?";
			SqlHelper sh=new SqlHelper();
			sh.updata(sql2, id);
			sh.updata(sql, id);
			sh.close();
			
			String sql1="select empid as Ա����,name as ����,sex as �Ա�,position as ְλ ,marriage as ��� from emp where 1=?";
		    String []paras1={"1"};
			
			//�����µ�����ģ�� ������
			eninfomodel o=new eninfomodel();
			o.query(sql1, paras1);
			this.jtb.setModel(o);
		}
	}
	
}
