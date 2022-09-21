package com.test;

import java.sql.*;

public class Test_dbjc {
	
	private static String url="jdbc:mysql://localhost:3306/shop";
			//"jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
	private static String user="root";
	private static String password="root";


		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		    System.out.println("------------------");//测试是否连接成功
			
			Connection conn=DriverManager.getConnection(url,user,password);
			
			System.out.println(conn);//测试是否连接建立完成
			
		    Statement stm=conn.createStatement();
		    
		    String sql="select * from admininfo";
		    
		    ResultSet rs=stm.executeQuery(sql);
		    
		    while(rs.next()){	
		    	System.out.print(rs.getInt("id")+"\t");
		    	System.out.print(rs.getString("note")+"\t");
		    	System.out.print(rs.getString("password")+"\t");
		    	System.out.print(rs.getString("adminName")+"\t");
		    	System.out.print(rs.getString("state")+"\t");
		    	System.out.print(rs.getString("editDate")+"\t");
		    	System.out.println(rs.getString("roleId")+"\t");
		    }
		    
		    rs.close();
		    stm.close();
		    conn.close();
		
		}


}
