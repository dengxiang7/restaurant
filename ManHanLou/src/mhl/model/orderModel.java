/*
 * 完成对订餐系统的各种操作
 */

package mhl.model;

import java.sql.*;
import mhl.db.*;
import java.util.*;

public class orderModel {
	
	ResultSet rs;
	ResultSetMetaData rsm;
	SqlHelper sh;
	
    //String message[];
	Vector<Vector> message;//=new Vector<Vector>();
 
	//查询操作   查询桌子的信息    订餐人员的信息       客人点菜的信息
public Vector<Vector> query(String sql,String []paras)
{
	
	
	sh=new SqlHelper();
	rs=sh.select(sql, paras);
	
	
	try {
		rsm=rs.getMetaData();
		message=new Vector<Vector>();
		//(rsm.getColumnCount());
		
		   while(rs.next())
		   { 
			   Vector<String> row=new Vector<String>();
			   for(int i=0;i<rsm.getColumnCount();i++)
	       {
				  
			  //message[i]=rs.getString(i+1);
				   row.add(rs.getString(i+1));
		   }
			message.add(row);
	    }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		sh.close();
	}
	
	return message;
	
	
	
}


//更新操作
public void update(String sql, String []paras)
{
	sh=new SqlHelper();
	try {
		sh.updata(sql, paras);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		sh.close();
	}
}
	
}
