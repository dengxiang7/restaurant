/*
 * 完成对人员的添加
 */

package mhl.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mhl.db.*;
import mhl.model.*;

public class addemp  extends JDialog implements ActionListener{

	//定义需要组件
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

	//初始化面板
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
			
		}
		
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
	
	//得到数据,并添加数据库
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
		
		if(e.getActionCommand().equals("确定"))
		{
			if(getdata())
			{
				JOptionPane.showMessageDialog(this, "添加失败");
			
			}
			this.dispose();
		}
		
		if(e.getActionCommand().equals("取消"))
		{
			this.dispose();
		}
	}

}
