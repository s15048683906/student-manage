package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.beans.StudentInfo;
import com.dao.StudentDao;

@WebServlet("/StudentServlet")

public class StudentServlet extends HttpServlet {
	
	StudentDao studentDao=new StudentDao();
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");
		
		if("add".equals(flag)){
			add(request,response);
		}
		if("manage".equals(flag)){
			manage(request,response);
		}
		else if("searchForUpdate".equals(flag)) {
			searchForUpdate(request,response);
		}
		else if("update".equals(flag)) {
			update(request,response);
		}
		else if("delete".equals(flag)) {
			delete(request,response);
		}
		
		
	}
	
	//学生删除
		private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id= Integer.parseInt(request.getParameter("id"));
			int result=studentDao.deleteStudentById(id);
			
			if(result==1) {
				request.setAttribute("msg", "删除成功");
				
				manage(request,response);
			}
		}
		
	 //学生信息修改
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		String password=request.getParameter("password");
		String studentName=request.getParameter("studentName");
		String sex=request.getParameter("sex");
		String class_=request.getParameter("class_");
		String major=request.getParameter("major");
		
		StudentInfo student=studentDao.getStudentById(id);
		student.setPassword(password);
		student.setStudentName(studentName);
		student.setSex(sex);
		student.setClass_(class_);
		student.setMajor(major);
		
		int result=studentDao.updateStudent(student);
		if(result==1) {
			request.setAttribute("msg", "更新成功");
			request.setAttribute("student", student);
			request.getRequestDispatcher("/student/student_update.jsp").forward(request, response);
		}
	}
	
	 //根据id查询学生信息，转到学生信息修改页面
	private void searchForUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		
		StudentInfo student=studentDao.getStudentById(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/student/student_update.jsp").forward(request, response);
	}

	//学生信息维护
	private void manage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		String tmp=request.getParameter("id");
		if(tmp==(null)||tmp.equals(""))
			id=0;
		else
		    id=Integer.parseInt(request.getParameter("id"));
		List<StudentInfo> studentList=studentDao.getStudentList(id);
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("/student/student_manage.jsp").forward(request, response);
	}

	//添加学生
	void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//取客户端传过来的数据
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		String studentName=request.getParameter("studentName");
		String sex=request.getParameter("sex");
		String class_=request.getParameter("class_");
		String major=request.getParameter("major");
		
		StudentInfo student= new StudentInfo();
		student.setId(id);
		student.setPassword(password);
		student.setStudentName(studentName);
		student.setSex(sex);
		student.setClass_(class_);
		student.setMajor(major);
		
		//调用dao层,进行数据操作, 并转向
		int result=StudentDao.addStudent(student);
		if(result==1) {
			request.setAttribute("msg", "学生添加成功");
			request.getRequestDispatcher("/student/student_add.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
}	
	

}
