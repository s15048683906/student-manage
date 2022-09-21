package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.CourseInfo;
import com.dao.CourseDao;


@WebServlet("/CourseServlet")

public class CourseServlet extends HttpServlet {

	CourseDao courseDao=new CourseDao();
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");
		
		if("manage".equals(flag)){
			manage(request,response);
		}		
	}


	//查询所有用户，转到用户维护界面
	private void manage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CourseInfo> courseList=courseDao.getAllCourses();
		request.setAttribute("courseList", courseList);
		request.getRequestDispatcher("/course/course_manage.jsp").forward(request, response);
	}
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				doGet(request, response);
	}
	
}
