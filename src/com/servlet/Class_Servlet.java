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

		if("addMclass_".equals(flag)) {//mclass_ Ϊ�༶
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
	
    //ɾ����Ʒ����
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		int result=class_Dao.deleteClass_ById(id);
		
		if(result==1) {
			request.setAttribute("msg", "ɾ���ɹ�");
			manage(request,response);
		}
		
	}	


	//���ݸ��Ӽ���ϵ����ʾ��Ʒ����ά������
	private void manage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int parentId=0;
		List<Class_Info> class_List=class_Dao.getClass_List(parentId);
		request.setAttribute("class_List", class_List);
		request.getRequestDispatcher("/class_/class__manage.jsp").forward(request, response);
	}

	//��ӷ���
	private void addMajor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ȡ�ͻ��˴�����������
		String class_Name=request.getParameter("class_Name");
		String des=request.getParameter("des");
		
		Class_Info class_= new Class_Info();
		class_.setClass_Name(class_Name);
		class_.setDes(des);
		
		//����dao��,�������ݲ���, ��ת��
		int result=class_Dao.addClass_(class_);
		if(result==1) {
			request.setAttribute("msg", "������ӳɹ�");
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
			request.setAttribute("msg", "�༶��ӳɹ�");
			request.getRequestDispatcher("/class_/class__add.jsp").forward(request, response);;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				doGet(request, response);
	}
	
}
