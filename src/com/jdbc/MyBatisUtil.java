package com.jdbc;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private MyBatisUtil(){}
	
	private static SqlSessionFactory factory;
		
	static {
		try {
			InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
			factory=new SqlSessionFactoryBuilder().build(in);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		return factory.openSession();
	}

	public static void close(SqlSession session) {
		if(session!=null) {
			session.close();
		}
	}
}