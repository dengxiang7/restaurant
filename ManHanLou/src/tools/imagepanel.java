/*
 * 这是一个可以动态加载一个图片做背景的JPanel
 */
package tools;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;

public class imagepanel extends JPanel{

	Image im;
	String []s;
	
	//构造函数去指定该Panel的大小
	
	public imagepanel(Image im)
	{
		this.im=im;
		
		//希望它的大小是自适应
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height);
		
	}	
	
	//画出背景
	public void paintComponent(Graphics g)
	{
		//清屏
		super.paintComponent(g);
	   g.drawImage(im, 0, 0, this.getWidth(),this.getHeight(),this);
	  
	}
	
}
