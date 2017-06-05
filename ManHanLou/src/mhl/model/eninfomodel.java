/*
 * 完成对人事表的各种操作
 */

package mhl.model;

import mhl.db.*;
import java.sql.*;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class eninfomodel extends  AbstractTableModel{

	//定义列名向量
   Vector<String> column;
   //定义行数据向量
   Vector<Vector> Row; 
   
   ResultSet rs;
   ResultSetMetaData rsm;
   
 //查询数据
	public void query(String sql,String []paras)
	{
		//初始化列
		this.column=new Vector<String>();
		//初始化行
		this.Row=new Vector<Vector>();
		
		SqlHelper sh=new SqlHelper();
		rs=sh.select(sql, paras);
		
		//从rs中可以得到一个ResultSetMetaData对象，这个对象可以得到rs 结果集返回了多少行多少列
		try {
			rsm=rs.getMetaData();
			for(int i=0;i<rsm.getColumnCount();i++)
		{
			this.column.add(rsm.getColumnName(i+1));
		}
			
			while(rs.next())
			{
				Vector<String> tem=new Vector<String>();
				
				for(int i=0;i<rsm.getColumnCount();i++)
				{
					
				   tem.add(rs.getString(i+1));
				
				}
				this.Row.add(tem);	
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sh.close();
			
		}
		
		
		
	}
	
	//更新数据
	public void updata()
	{
		
	}
	
	
	//得到多少列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.column.size();
	}
	
	//得到多少行

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.Row.size();
	}

	//得到某行某列
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return  ((Vector)this.Row.get(arg0)).get(arg1);
	}

	
	//的得到列名
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.column.get(column);
	}

}
