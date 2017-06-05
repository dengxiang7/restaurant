/*
 * 完成对点餐，预定的界面
 */
package mhl.view2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mhl.db.*;
import mhl.model.*;

public class BookTablePanel extends JDialog implements ActionListener{
	
	JPanel jp1,jp2,jp3,jp4,jp5;
	JButton jb1,jb2;
	JLabel name,phone,time,number;
	JTextField nameT,phoneP,timeP,numberP;
	
	int id1;
	orderModel o;
	boolean b=false;
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	}

	
	
	public  BookTablePanel(JFrame ower,String title,boolean model,int id)
	{
		
		
		super(ower,title,model);
		
		this.id1=id+1;
		if(id1==0)
		{
           JOptionPane.showMessageDialog(this, "请选择一张桌子");
			
			return; 
		}
		name=new JLabel("姓      名");
		nameT=new JTextField(10);
		jp1=new JPanel();
		jp1.add(name);
		jp1.add(nameT);
		jp2=new JPanel();
		phone=new JLabel("电话号码");
		phoneP=new JTextField(10);
		jp2.add(phone);
		jp2.add(phoneP);
		jp3=new JPanel();
		time=new JLabel("就餐时间");
		timeP=new JTextField(10);
		jp3.add(time);
		jp3.add(timeP);
		jp4=new JPanel();
		number=new JLabel("人      数     ");
		numberP=new JTextField(10);
		jp4.add(number);
		jp4.add(numberP);
		jp5=new JPanel();
		jb1=new JButton("确定");
		jb1.addActionListener(this);
		jb2=new JButton("取消");	
		jb2.addActionListener(this);
		jp5.add(jb1);
		jp5.add(jb2);
		
		this.setLayout(new GridLayout(5,1));
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		
		//this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.setLocation(500,100);
		this.setSize(300,300);
	    this.setVisible(true);
	    
	    
	}
	
	public boolean date()
	{
		String sql="insert into bookp values(?,?,?,?,?)";
		String []paras={String.valueOf(id1),this.nameT.getText(),this.phoneP.getText(),this.timeP.getText(),this.numberP.getText()};
	    o=new orderModel();
	    o.update(sql, paras);
	    
	    return b;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==this.jb1)
		{
			date();
			b=true;
			this.dispose();
		}
		if(e.getSource()==this.jb2)
		{
			b=false;
			this.dispose();
		}
		
		
	}
	

}
