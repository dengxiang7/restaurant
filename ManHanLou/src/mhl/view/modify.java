/*
 * 修改
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

	
	//初始化
	public void init()
	{
		jl[0]=new JLabel("员工号: ",JLabel.RIGHT);
		jl[1]=new JLabel("姓名:     ",JLabel.RIGHT);
		jl[2]=new JLabel("照片:     ",JLabel.RIGHT);
		jl[3]=new JLabel("性别:     ",JLabel.RIGHT);
		jl[4]=new JLabel("住址:     ",JLabel.RIGHT);
		jl[5]=new JLabel("生日:     ",JLabel.RIGHT);
		jl[6]=new JLabel("身份证: ",JLabel.RIGHT);
		jl[7]=new JLabel("学历:     ",JLabel.RIGHT);
		jl[8]=new JLabel("职位:     ",JLabel.RIGHT);
		jl[9]=new JLabel("婚否:     ",JLabel.RIGHT);
		jl[10]=new JLabel("座机号: ",JLabel.RIGHT);
		jl[11]=new JLabel("手机号: ",JLabel.RIGHT);
		jl[12]=new JLabel("邮箱:     ",JLabel.RIGHT);
		jl[13]=new JLabel("入职时间:",JLabel.RIGHT);
		jl[14]=new JLabel("备注:     ",JLabel.RIGHT);
		
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
		JButton jb1=new JButton("确定");
		jb1.addActionListener(this);
		jb1.setActionCommand("确定");
		JButton jb2=new JButton("取消");
		jb2.addActionListener(this);
		jb2.setActionCommand("取消");
		
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
	
	//的到数据，并发送sql
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
		
		if(shuju[8]!="主管"||shuju[8]!="经理"||shuju[8]!="收银员")
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
		
		if(e.getActionCommand().equals("确定"))
		{
			if(!data())
			{
				JOptionPane.showMessageDialog(this, "修改失败");
			}
			this.dispose();
		}
		if(e.getActionCommand().equals("取消"))
		{
			this.dispose();
		}
	}
	


}
