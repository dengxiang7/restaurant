/*
 * �Ե�¼��Ա�Ĺ������
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
	//��rs�п��Եõ�һ��ResultSetMetaData�������������Եõ�rs ����������˶����ж�����
	ResultSetMetaData rsm;
	
	//��ѯ
	public void query(String sql,String []paras)
	{
		this.count=new Vector<String>();
		this.row=new Vector<Vector>();
		
		//this.sql="select emp.empid as Ա����,emp.name as ����,emp.position as ְλ ,denglu.password  "
			//	+ "as���� from emp,denglu where emp.empid=denglu.empid and 1=? ";
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

	//����
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
	
	//�õ�����
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.count.size();
	}

	//�õ�����
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.row.size();
	}
	
	//�õ�����
   @Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.count.get(column);
	}

	// �õ�ĳ��ĳ�е�����
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return (String)this.row.get(arg0).get(arg1);
	}

}
