/*
 * ����һ�����Զ�̬����һ��ͼƬ��������JPanel
 */
package tools;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;

public class imagepanel extends JPanel{

	Image im;
	String []s;
	
	//���캯��ȥָ����Panel�Ĵ�С
	
	public imagepanel(Image im)
	{
		this.im=im;
		
		//ϣ�����Ĵ�С������Ӧ
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height);
		
	}	
	
	//��������
	public void paintComponent(Graphics g)
	{
		//����
		super.paintComponent(g);
	   g.drawImage(im, 0, 0, this.getWidth(),this.getHeight(),this);
	  
	}
	
}
