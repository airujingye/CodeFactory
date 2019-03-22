package com.sweet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sweet.helper.DBHelper;

public class TableInfo {
	public static void main(String[] args) {
		String sql="select identifier,name from rgs_job_category union select identifier,name from rgs_job_title";
		ResultSet resultSet=new DBHelper().executeQuery(sql);
		try {
			StringBuffer sb=new StringBuffer(); 
			while(resultSet.next()){
				sb.append("fun_a['"+resultSet.getString("identifier")+"']='"+resultSet.getString("name")+"';\n");
			}
			System.out.println(sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
