/*
 * �����û�������ģ�ͣ�������ɶ����û��ĸ��ֲ���
 *
 *������Ҫ��д��Ŀ��Ҫ��ҵ�����
 */

package mhl.model;

import mhl.db.*;
import java.sql.*;

public class UserModel {
	
	/**
	 * 
	 * @param uid
	 * @param p
	 * @return   ����ְλ����������ڷ��ؿ�
	 */
	
	SqlHelper sp;
	
  public String[] checkuser(String uid,String p)
 {
	String message[]=new String[2];
	
	try{
	//��֯sql���Ͳ����б�
	String sql="select emp.position, emp.name from emp ,denglu where denglu.empid=emp.empid and denglu.empid=? and denglu.password=?";
  
	String paras[]={uid,p};
	
	 sp=new SqlHelper();
	
	ResultSet rs=sp.select(sql, paras);
	
	if(rs.next())
	{
		//ȡ��ְλ
		message[0] =rs.getString(1);
		message[1] =rs.getString(2);
	}
	
	}catch(Exception e){
	
	
	
	}finally{
		sp.close();
		
	}
	
	return message;
	
 }

}
