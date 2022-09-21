package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.beans.StudentInfo;
import com.jdbc.MyBatisUtil;

public class StudentDao {
	
	//���ѧ��
	public static int addStudent(StudentInfo student) {	
		SqlSession s=MyBatisUtil.getSession();
		int result=s.insert("student.addStudent",student);
		
		//ע��һ��Ҫ�ύ����
		s.commit();  	
		s.close();
		
		return result;	
	}

	//��ѯ����ѧ��
	public List<StudentInfo> getStudentList(int id) {
			SqlSession s=MyBatisUtil.getSession();
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id", id);
			List<StudentInfo> studentList=s.selectList("student.getStudentList",map);
			MyBatisUtil.close(s);
			return  studentList;
	}
	
	//����id��ѯ
	public StudentInfo getStudentById(int id) {
		SqlSession s=MyBatisUtil.getSession();
		StudentInfo student=s.selectOne("student.getStudentById",id);
		s.close();
		return student;
	}
	
	//����ѧ��
	public int updateStudent(StudentInfo student) {
		SqlSession s=MyBatisUtil.getSession();
		int result=s.update("student.updateStudent",student);
		s.commit();  	
		s.close();
		return result;
	}
	
	//ɾ��ѧ��
	public int deleteStudentById(int id) {
		SqlSession s=MyBatisUtil.getSession();
		int result=s.delete("student.deleteStudentById",id);
		s.commit();  	
		s.close();
		
		return result;	
	}
	

}
