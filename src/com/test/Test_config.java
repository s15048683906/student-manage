package com.test;

import java.io.IOException;
//import java.util.List;
import com.beans.RoleInfo;
import com.dao.RoleDao;
//import java.io.InputStream;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;   //===> jdbc �е� DriverManager
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Test_config {
	
	public static void main(String[] args) throws IOException {
	
	      RoleDao dao=new RoleDao();
			
		
		 RoleInfo role=new RoleInfo(); role.setRoleName("���Ϲ���ϯ");
		 role.setDes("��û�õ�һ����ɫ");
		 
		 dao.addRole(role);
	  
		 System.out.println("ok");
		 
		//����ɾ��	
		//  dao.deleteRoleById(12);
			
	    //���Ը���
		
//		  RoleInfo role=dao.getRoleById(14); role.setRoleName("�׹���ͳ");
//		  role.setDes("�׳�"); dao.updateRole(role);
		 

//		List<RoleInfo> roleList=dao.getAllRoles();
//		
//		for(RoleInfo role:roleList) {
//			System.out.println(role);
//		}
		  
	}
	
//	public static void main(String[] args) throws IOException {		
//		InputStream  in =Resources.getResourceAsStream("mybatis-config.xml");
//		SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
//		SqlSession session=factory.openSession();   //session �൱��jdbc�е� Connection 
//		RoleInfo role=session.selectOne("role.getRoleById",2);
//		System.out.println(role);
//		session.close();			
//	}
	

}
