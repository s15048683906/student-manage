package com.jdbc;
import java.sql.*;

//数据库访问工具类
public class DBUtil {
	
	public static void main(String[] args) {
		DBUtil.getConn();
		System.out.println("OK");
	}
	private static String url="jdbc:mysql://localhost:3306/student";
			//"jdbc:mysql://localhost:3306/shop?characterEncoding=utf8&useSSL=false&rewriteBatchedStatements=true&serverTimezone=UTC";private static String user="root";
	private static String user="root";
	private static String password="root";
	
	//构造函数私有化,可以防止别人new本类的实例
	private DBUtil(){}
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//得到连接
	public static Connection getConn(){
		Connection conn=null;	
		try {
			conn=DriverManager.getConnection(url, user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return conn;
	}
	
	
	//关连接
	public static void close(ResultSet rs,Statement stm,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stm!=null){
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
