/*
 * 这是用户表数据模型，用它完成对用用户的各种操作
 *
 *这里主要编写项目需要的业务操作
 */

package mhl.model;

import mhl.db.*;
import java.sql.*;

public class UserModel {
	
	/**
	 * 
	 * @param uid
	 * @param p
	 * @return   返回职位，如果不存在返回空
	 */
	
	SqlHelper sp;
	
  public String[] checkuser(String uid,String p)
 {
	String message[]=new String[2];
	
	try{
	//组织sql语句和参数列表
	String sql="select emp.position, emp.name from emp ,denglu where denglu.empid=emp.empid and denglu.empid=? and denglu.password=?";
  
	String paras[]={uid,p};
	
	 sp=new SqlHelper();
	
	ResultSet rs=sp.select(sql, paras);
	
	if(rs.next())
	{
		//取出职位
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
