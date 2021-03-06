package com.sweet.helper;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class MSSQLDBHelper {
	private java.sql.Connection connection;  
    private java.sql.PreparedStatement preparedStatement;  
    
    public MSSQLDBHelper(){
    	try {  
            connection = DriverManager.getConnection(  
            		Config.DATABASE_URL, Config.DATABASE_USERNAME, Config.DATABASE_PASSWORD);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }
    
    static {  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void close() {  
        if (connection != null) {  
            try {  
                connection.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    public ResultSet executeQuery(String sql, LinkedList<Object> params) {  
        try {  
            preparedStatement = connection.prepareStatement(sql);  
            if (params != null) {  
                int i = 1;  
                for (Object p : params) {  
                    preparedStatement.setObject(i++, p);  
                }  
            }  
            return preparedStatement.executeQuery();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
}
