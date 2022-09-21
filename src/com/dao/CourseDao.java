package com.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.beans.CourseInfo;
import com.jdbc.MyBatisUtil;

public class CourseDao {
	
	
	//��ѯ���н�ɫ
	public List<CourseInfo> getAllCourses(){
		SqlSession s=MyBatisUtil.getSession();
		List<CourseInfo> courseList=s.selectList("course.getAllCourses");
		s.close();
		return  courseList;
	}

	
}
