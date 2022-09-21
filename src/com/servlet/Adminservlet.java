package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.AdminInfo;
import com.dao.AdminDao;

@WebServlet("/Adminservlet")

public class Adminservlet extends HttpServlet {
	AdminDao dao=new AdminDao();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");
		
		if("login".equals(flag)) {
			login(request,response);
		}
		else if("add".equals(flag)) {
			add(request,response);
		}
		else if("manager".equals(flag)){
			manager(request,response);
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
		else if("logout".equals(flag)) {
			logout(request,response);
		}
		
	}
	

	//�û�ɾ��
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		int result=dao.deleteAdminById(id);
		
		if(result==1) {
			request.setAttribute("msg", "ɾ���ɹ�");
			
			manager(request,response);
		}
	}



    //�û�����
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		String adminName=request.getParameter("adminName");
		String password=request.getParameter("password");
		String note=request.getParameter("note");
		
		AdminInfo admin=dao.getAdminById(id);
		admin.setAdminName(adminName);
		admin.setPassword(password);
		admin.setNote(note);
		
		int result=dao.updateAdmin(admin);
		if(result==1) {
			request.setAttribute("msg", "���³ɹ�");
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("/admin/admin_update.jsp").forward(request, response);
		}
	}


    //����id��ѯ�û���Ϣ��ת���û�����ҳ��
	private void searchForUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		
		AdminInfo admin=dao.getAdminById(id);
		request.setAttribute("admin", admin);
		request.getRequestDispatcher("/admin/admin_update.jsp").forward(request, response);
	}
	
	//��ѯ�����û���ת���û�ά������
	private void manager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AdminInfo> adminList=dao.getAllAdmin();
		request.setAttribute("adminList", adminList);
		
		//System.out.println(adminList.size()+"-----------------------------");
		request.getRequestDispatcher("/admin/admin_manager.jsp").forward(request, response);
	}

	//�û����
		void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//ȡ�ͻ��˴�����������
			String adminName=request.getParameter("adminName");
			String password=request.getParameter("password");
			String note=request.getParameter("note");
			
			AdminInfo admin= new AdminInfo();
			admin.setAdminName(adminName);
			admin.setPassword(password);
			admin.setNote(note);
			admin.setState("1");
			admin.setRoleId(1);
			
//			System.out.println("---------------------------------------------");
//			System.out.println("---------------------------------------------");
//			System.out.println("---------------------------------------------");
//			System.out.println("---------------------------------------------");
//			System.out.println("---------------------------------------------");
			
			//����dao��,�������ݲ���, ��ת��
			int result=dao.addAdmin(admin);
			if(result==1) {
				request.setAttribute("msg", "�û���ӳɹ�");
				request.getRequestDispatcher("/admin/admin_add.jsp").forward(request, response);
			}
		}
	
	//�û���¼
	void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���տͻ��˴�����������
		String adminName=request.getParameter("adminName");
		String password=request.getParameter("password");
		
		//����dao�����Ч��
		AdminInfo admin=dao.safeLogin(adminName, password);
		
		if(admin!=null) {
			//���û���Ϣ�ŵ�session��������
			request.getSession().setAttribute("g_admin", admin);
			request.getRequestDispatcher("/main.html").forward(request, response);
		}
		else {
			request.setAttribute("msg", "�û�����������������µ�½");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	//ע���˳�
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��յ�ǰ�û���session
		request.getSession().invalidate();
		response.getWriter().println("<script>window.top.location.href='login.jsp'</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
