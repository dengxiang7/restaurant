/*
 * �޸����봰��
 */
package mhl.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mhl.model.*;

public class ModifyPassword extends JDialog  implements ActionListener{

	
	JLabel jl;
	JTextField jtf;
	JButton jb1,jb2;
	JPanel jp1,jp2;
	
	String []paras;
	
	dengluModel dm;
	
	//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
	public void init()
	{
		jl=new JLabel("������");
		jtf=new JTextField(10);
		jtf.setText(this.paras[1]);
		jb1=new JButton("ȷ��");
		jb1.addActionListener(this);
		jb1.setActionCommand("ȷ��");
		jb2=new JButton("ȡ��");
		jb2.addActionListener(this);
		jb2.setActionCommand("ȡ��");
		
		jp1=new JPanel(new FlowLayout());
		jp1.add(jl);
		jp1.add(jtf);
		jp2=new JPanel(new FlowLayout());
		jp2.add(jb1);
		jp2.add(jb2);
		
		this.setLayout(new GridLayout(2,1));
		
		this.add(jp1);
		this.add(jp2);
		
		
		this.setSize(300,100);
		this.setLocation(450, 300);
		this.setVisible(true);
				
				
		
	}
	
	//��������
	public void data()
	{
		dm=new dengluModel();
		String sql="update denglu set password=? where empid=?";
		String []password={this.jtf.getText(),paras[0]};
		dm.updata(sql, password);
	}
	
	
	public ModifyPassword(JFrame ower,String title ,boolean model,String []paras)
	{
		super(ower,title,model);
		this.paras=paras;
		init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("ȷ��"))
		{
			data();
			this.dispose();
		}
		if(e.getActionCommand().equals("ȡ��"))
		{
			
			this.dispose();
		}
	}


}
