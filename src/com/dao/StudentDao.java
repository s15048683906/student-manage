package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.beans.StudentInfo;
import com.jdbc.MyBatisUtil;

public class StudentDao {
	
	//添加学生
	public static int addStudent(StudentInfo student) {	
		SqlSession s=MyBatisUtil.getSession();
		int result=s.insert("student.addStudent",student);
		
		//注意一定要提交事务
		s.commit();  	
		s.close();
		
		return result;	
	}

	//查询所有学生
	public List<StudentInfo> getStudentList(int id) {
			SqlSession s=MyBatisUtil.getSession();
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id", id);
			List<StudentInfo> studentList=s.selectList("student.getStudentList",map);
			MyBatisUtil.close(s);
			return  studentList;
	}
	
	//根据id查询
	public StudentInfo getStudentById(int id) {
		SqlSession s=MyBatisUtil.getSession();
		StudentInfo student=s.selectOne("student.getStudentById",id);
		s.close();
		return student;
	}
	
	//更新学生
	public int updateStudent(StudentInfo student) {
		SqlSession s=MyBatisUtil.getSession();
		int result=s.update("student.updateStudent",student);
		s.commit();  	
		s.close();
		return result;
	}
	
	//删除学生
	public int deleteStudentById(int id) {
		SqlSession s=MyBatisUtil.getSession();
		int result=s.delete("student.deleteStudentById",id);
		s.commit();  	
		s.close();
		
		return result;	
	}
	

}
