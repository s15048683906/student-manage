package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.beans.Class_Info;
import com.dao.Class_Dao;

@WebServlet("/Class_Servlet")

public class Class_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Class_Dao class_Dao=new Class_Dao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");

		if("addMclass_".equals(flag)) {//mclass_ 为班级
			addMclass_(request,response);
		}
		else if("addMajor".equals(flag)) {
			addMajor(request,response);
		}
		else if("manage".equals(flag)){
			manage(request,response);
		}
		else if("delete".equals(flag)){
			delete(request,response);
		}

	}
	
    //删除商品分类
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		int result=class_Dao.deleteClass_ById(id);
		
		if(result==1) {
			request.setAttribute("msg", "删除成功");
			manage(request,response);
		}
		
	}	


	//根据父子级关系，显示商品分类维护界面
	private void manage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int parentId=0;
		List<Class_Info> class_List=class_Dao.getClass_List(parentId);
		request.setAttribute("class_List", class_List);
		request.getRequestDispatcher("/class_/class__manage.jsp").forward(request, response);
	}

	//添加分类
	private void addMajor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取客户端传过来的数据
		String class_Name=request.getParameter("class_Name");
		String des=request.getParameter("des");
		
		Class_Info class_= new Class_Info();
		class_.setClass_Name(class_Name);
		class_.setDes(des);
		
		//调用dao层,进行数据操作, 并转向
		int result=class_Dao.addClass_(class_);
		if(result==1) {
			request.setAttribute("msg", "分类添加成功");
			request.getRequestDispatcher("/class_/major_add.jsp").forward(request, response);
		}
		
	}

	private void addMclass_(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int majorId=Integer.parseInt(request.getParameter("majorId"));
		String class_Name=request.getParameter("class_Name");
		String des=request.getParameter("des");
		
		Class_Info class_=new Class_Info();
		class_.setParentId(majorId);
		class_.setClass_Name(class_Name);
		class_.setDes(des);
		
		int result=class_Dao.addClass_(class_);
		if(result==1) {
			request.setAttribute("msg", "班级添加成功");
			request.getRequestDispatcher("/class_/class__add.jsp").forward(request, response);;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				doGet(request, response);
	}
	
}
