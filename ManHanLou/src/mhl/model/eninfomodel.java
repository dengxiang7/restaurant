/*
 * ��ɶ����±�ĸ��ֲ���
 */

package mhl.model;

import mhl.db.*;
import java.sql.*;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class eninfomodel extends  AbstractTableModel{

	//������������
   Vector<String> column;
   //��������������
   Vector<Vector> Row; 
   
   ResultSet rs;
   ResultSetMetaData rsm;
   
 //��ѯ����
	public void query(String sql,String []paras)
	{
		//��ʼ����
		this.column=new Vector<String>();
		//��ʼ����
		this.Row=new Vector<Vector>();
		
		SqlHelper sh=new SqlHelper();
		rs=sh.select(sql, paras);
		
		//��rs�п��Եõ�һ��ResultSetMetaData�������������Եõ�rs ����������˶����ж�����
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
	
	//��������
	public void updata()
	{
		
	}
	
	
	//�õ�������
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.column.size();
	}
	
	//�õ�������

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.Row.size();
	}

	//�õ�ĳ��ĳ��
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return  ((Vector)this.Row.get(arg0)).get(arg1);
	}

	
	//�ĵõ�����
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.column.get(column);
	}

}
