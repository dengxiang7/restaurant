/*
 * 对数据库操作的类
 * 对数据库的操作 就是crud
 *调用存储过程
 */

package mhl.db;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class SqlHelper {
	
	//定义需要的对象
	PreparedStatement ps=null; //活动对象
	ResultSet rs=null;  //结果集
	Connection ct=null;//连接对象
	
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String uri="jdbc:sqlserver://localhost:1433;DatabaseName=restaurant";
	String name="sa";
	String pass="dengxiang,.!";
	
	//构造函数初始化ct;
	public SqlHelper()
	{
		
		try {
			//加载驱动
			Class.forName(driver);
			//得到连接
			ct=DriverManager.getConnection(uri,name,pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	//处理添加，修改，删除
	public boolean updata(String sql,String []paras)
	{
		boolean b=true;
		
		try {
			
			
			ps=ct.prepareStatement(sql);
			
			//对sql赋值
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			
			if(ps.executeUpdate()!=-1)
			{
				b=false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
	        e.printStackTrace();
	        
	        b=false;
		}
		
		
		
		return b;
	}
	
	//查询方法
	public ResultSet select(String sql,String []paras)
	{
		try {
			//向数据库发送sql语句
			ps=ct.prepareStatement(sql);
			//对sql的参数赋值
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			//执行sql
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
		//在这里关闭资源，结果集就用不了了
	}
	
	//关闭资源的方法
	public void close()
	{
		
			try {
				if(rs!=null)
				  rs.close();
				if(ps!=null)
					ps.close();
				if(ct!=null)
					ct.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
