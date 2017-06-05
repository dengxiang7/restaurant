/*
 * �����ݿ��������
 * �����ݿ�Ĳ��� ����crud
 *���ô洢����
 */

package mhl.db;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class SqlHelper {
	
	//������Ҫ�Ķ���
	PreparedStatement ps=null; //�����
	ResultSet rs=null;  //�����
	Connection ct=null;//���Ӷ���
	
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String uri="jdbc:sqlserver://localhost:1433;DatabaseName=restaurant";
	String name="sa";
	String pass="dengxiang,.!";
	
	//���캯����ʼ��ct;
	public SqlHelper()
	{
		
		try {
			//��������
			Class.forName(driver);
			//�õ�����
			ct=DriverManager.getConnection(uri,name,pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	//������ӣ��޸ģ�ɾ��
	public boolean updata(String sql,String []paras)
	{
		boolean b=true;
		
		try {
			
			
			ps=ct.prepareStatement(sql);
			
			//��sql��ֵ
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
	
	//��ѯ����
	public ResultSet select(String sql,String []paras)
	{
		try {
			//�����ݿⷢ��sql���
			ps=ct.prepareStatement(sql);
			//��sql�Ĳ�����ֵ
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			//ִ��sql
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
		//������ر���Դ����������ò�����
	}
	
	//�ر���Դ�ķ���
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
