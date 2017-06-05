/*
 * 显示员工的详细信息
 */
package mhl.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mhl.model.*;

public class empinformation extends JDialog implements ActionListener{

	
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15;
    //JLabel []jl;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11,jtf12,jtf13,jtf14,jtf15;
	//JTextField []jtf;
	JButton jb1,jb2;
	
	JPanel []jp=new JPanel[16];
	
	String []shuju2=null;
	
	
	

	
	
	//初始化界面
	public void init()
	{
		
		
		jl1=new JLabel("员工号: ",JLabel.RIGHT);
		jl2=new JLabel("姓名:     ",JLabel.RIGHT);
		jl3=new JLabel("照片:     ",JLabel.RIGHT);
		jl4=new JLabel("性别:     ",JLabel.RIGHT);
		jl5=new JLabel("住址:     ",JLabel.RIGHT);
		jl6=new JLabel("生日:     ",JLabel.RIGHT);
		jl7=new JLabel("身份证: ",JLabel.RIGHT);
		jl8=new JLabel("学历:     ",JLabel.RIGHT);
		jl9=new JLabel("职位:     ",JLabel.RIGHT);
		jl10=new JLabel("婚否:     ",JLabel.RIGHT);
		jl11=new JLabel("座机号: ",JLabel.RIGHT);
		jl12=new JLabel("手机号: ",JLabel.RIGHT);
		jl13=new JLabel("邮箱:     ",JLabel.RIGHT);
		jl14=new JLabel("入职时间:",JLabel.RIGHT);
		jl15=new JLabel("备注:     ",JLabel.RIGHT);
		
		
		jtf1=new JTextField (10);
		jtf1.setText(shuju2[0]);
		jtf2=new JTextField (10);
		jtf2.setText(shuju2[1]);
		jtf3=new JTextField (10);
		jtf3.setText(shuju2[2]);
		jtf4=new JTextField (10);
		jtf4.setText(shuju2[3]);
		jtf5=new JTextField (10);
		jtf5.setText(shuju2[4]);
		jtf6=new JTextField (10);
		jtf6.setText(shuju2[5].substring(0,10));
		jtf7=new JTextField (10);
		jtf7.setText(shuju2[6]);
		jtf8=new JTextField (10);
		jtf8.setText(shuju2[7]);
		jtf9=new JTextField (10);
		jtf9.setText(shuju2[8]);
		jtf10=new JTextField (10);
		jtf10.setText(shuju2[9]);
		jtf11=new JTextField (10);
		jtf11.setText(shuju2[10]);
		jtf12=new JTextField (10);
		jtf12.setText(shuju2[11]);
		jtf13=new JTextField (10);
		jtf13.setText(shuju2[12]);
		jtf14=new JTextField (10);
		jtf14.setText(shuju2[13].substring(0,10));
		jtf15=new JTextField (10);
		jtf15.setText(shuju2[14]);
		

		for(int i=0;i<16;i++)
		{
			jp[i]=new JPanel();
		}
		
		jb1=new JButton("确定");
		jb1.addActionListener(this);
		jb1.setActionCommand("确定");
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jb2.setActionCommand("取消");
		
		this.setLayout(new GridLayout(16,1));
		
		jp[0].add(jl1);
		jp[0].add(jtf1);
		jp[1].add(jl2);
		jp[1].add(jtf2);
		jp[2].add(jl3);
		jp[2].add(jtf3);
		jp[3].add(jl4);
		jp[3].add(jtf4);
		jp[4].add(jl5);
		jp[4].add(jtf5);
		jp[5].add(jl6);
		jp[5].add(jtf6);
		jp[6].add(jl7);
		jp[6].add(jtf7);
		jp[7].add(jl8);
		jp[7].add(jtf8);
		jp[8].add(jl9);
		jp[8].add(jtf9);
		jp[9].add(jl10);
		jp[9].add(jtf10);
		jp[10].add(jl11);
		jp[10].add(jtf11);
		jp[11].add(jl12);
		jp[11].add(jtf12);
		jp[12].add(jl13);
		jp[12].add(jtf13);
		jp[13].add(jl14);
		jp[13].add(jtf14);
		jp[14].add(jl15);
		jp[14].add(jtf15);
		jp[15].add(jb1);
		jp[15].add(jb2);
		
		
		
	for(int i=0;i<16;i++)
	{
		this.add(jp[i]);
	}
		
	}
	
	public empinformation(Frame ower,String title,boolean model,String []shuju)
	{
		super(ower,title,model);
		this.shuju2=shuju;
		
		//System.out.println(shuju2[0]);
		init();
		
		this.setLocation(500, 100);
		this.setSize(300,500);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("确定"))
		{
			this.dispose();
		}
		if(e.getActionCommand().equals("取消"))
		{
			this.dispose();
		}
	}

}
