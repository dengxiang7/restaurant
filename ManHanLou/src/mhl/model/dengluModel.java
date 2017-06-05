/*
 * 对登录人员的管理操作
 */
package mhl.model;

import java.sql.*;
import mhl.db.*;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;;


public class dengluModel extends AbstractTableModel{

	Vector<String> count;
	Vector<Vector> row;
	
	String sql;
	String []paras={"1"};
	
	SqlHelper sq;
	
	ResultSet rs;
	//从rs中可以得到一个ResultSetMetaData对象，这个对象可以得到rs 结果集返回了多少行多少列
	ResultSetMetaData rsm;
	
	//查询
	public void query(String sql,String []paras)
	{
		this.count=new Vector<String>();
		this.row=new Vector<Vector>();
		
		//this.sql="select emp.empid as 员工号,emp.name as 姓名,emp.position as 职位 ,denglu.password  "
			//	+ "as密码 from emp,denglu where emp.empid=denglu.empid and 1=? ";
		//this.paras="";
		sq=new SqlHelper();
		rs=sq.select(sql, paras);
		try {
			
			rsm=rs.getMetaData();
			
			for(int i=0;i<rsm.getColumnCount();i++)
			{
				this.count.add(rsm.getColumnName(i+1));
			}
			
			while(rs.next())
			{
				Vector<String> temp=new Vector<String>();
				for(int i =0;i<rsm.getColumnCount();i++){
					temp.add(rs.getString(i+1));
				}
				this.row.add(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sq.close();
		}
		
		
	}

	//更新
	public void updata(String sql,String []paras)
	{
		sq=new SqlHelper();
		try {
			sq.updata(sql, paras);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sq.close();
		}
	}
	
	//得到列数
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.count.size();
	}

	//得到行数
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.row.size();
	}
	
	//得到列名
   @Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.count.get(column);
	}

	// 得到某行某列的数据
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return (String)this.row.get(arg0).get(arg1);
	}

}
