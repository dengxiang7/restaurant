/*
 * �޸�
 */
package mhl.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mhl.model.*;
import mhl.db.*;

public class modify extends JDialog implements ActionListener{

	JLabel []jl=new JLabel[15];
	JTextField []jtf=new JTextField[15];
	JPanel []jp=new JPanel[16];
	
	JButton jb1,jb2;
	
	String []shuju=new String[15];
	
	String []paras=new String[15];

	
	//��ʼ��
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
			jtf[i].setText(shuju[i]);
			
		}
		jtf[5].setText(shuju[5].substring(0,10));
		jtf[13].setText(shuju[13].substring(0,10));
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
	
	public modify(Frame ower,String title,boolean model,String []shuju)
	{
		super(ower,title,model);
		
		this.shuju=shuju;
		
		 init();
		 

			this.setLocation(500,100);
			this.setSize(300,500);
		    this.setVisible(true);
		
	}
	
	//�ĵ����ݣ�������sql
	public boolean data()
	{
		boolean b=true;
		
		String sql="update emp set empid=?,name=?,empimage=?,sex=?,adress=?,birthday=?,idcard=?,education=?,position=?,marriage=?,zuoji=?,phonenumber=?,mail=?,registertime=?,beizu=? where empid=?";
		String []shuju=new String[16];
		
		
		
		for(int i=0;i<15;i++)
		{
			shuju[i]=jtf[i].getText();
		}
		shuju[15]=jtf[0].getText();
		SqlHelper sh=new SqlHelper();
		
		if(!sh.updata(sql, shuju))
		{
			b=true;
		}
		
		if(shuju[8]!="����"||shuju[8]!="����"||shuju[8]!="����Ա")
		{
			String sql3="delete from denglu where empid=?";
			String []paras={shuju[0]};
			sh.updata(sql3, paras);
		}
		
		sh.close();
		
		return b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("ȷ��"))
		{
			if(!data())
			{
				JOptionPane.showMessageDialog(this, "�޸�ʧ��");
			}
			this.dispose();
		}
		if(e.getActionCommand().equals("ȡ��"))
		{
			this.dispose();
		}
	}
	


}
