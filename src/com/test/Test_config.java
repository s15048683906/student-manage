package com.test;

import java.io.IOException;
//import java.util.List;
import com.beans.RoleInfo;
import com.dao.RoleDao;
//import java.io.InputStream;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;   //===> jdbc 中的 DriverManager
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Test_config {
	
	public static void main(String[] args) throws IOException {
	
	      RoleDao dao=new RoleDao();
			
		
		 RoleInfo role=new RoleInfo(); role.setRoleName("联合国主席");
		 role.setDes("最没用的一个角色");
		 
		 dao.addRole(role);
	  
		 System.out.println("ok");
		 
		//测试删除	
		//  dao.deleteRoleById(12);
			
	    //测试更新
		
//		  RoleInfo role=dao.getRoleById(14); role.setRoleName("米国总统");
//		  role.setDes("白痴"); dao.updateRole(role);
		 

//		List<RoleInfo> roleList=dao.getAllRoles();
//		
//		for(RoleInfo role:roleList) {
//			System.out.println(role);
//		}
		  
	}
	
//	public static void main(String[] args) throws IOException {		
//		InputStream  in =Resources.getResourceAsStream("mybatis-config.xml");
//		SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
//		SqlSession session=factory.openSession();   //session 相当于jdbc中的 Connection 
//		RoleInfo role=session.selectOne("role.getRoleById",2);
//		System.out.println(role);
//		session.close();			
//	}
	

}
