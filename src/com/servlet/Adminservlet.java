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
	

	//用户删除
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		int result=dao.deleteAdminById(id);
		
		if(result==1) {
			request.setAttribute("msg", "删除成功");
			
			manager(request,response);
		}
	}



    //用户更新
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
			request.setAttribute("msg", "更新成功");
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("/admin/admin_update.jsp").forward(request, response);
		}
	}


    //根据id查询用户信息，转到用户更新页面
	private void searchForUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		
		AdminInfo admin=dao.getAdminById(id);
		request.setAttribute("admin", admin);
		request.getRequestDispatcher("/admin/admin_update.jsp").forward(request, response);
	}
	
	//查询所有用户，转到用户维护界面
	private void manager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AdminInfo> adminList=dao.getAllAdmin();
		request.setAttribute("adminList", adminList);
		
		//System.out.println(adminList.size()+"-----------------------------");
		request.getRequestDispatcher("/admin/admin_manager.jsp").forward(request, response);
	}

	//用户添加
		void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//取客户端传过来的数据
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
			
			//调用dao层,进行数据操作, 并转向
			int result=dao.addAdmin(admin);
			if(result==1) {
				request.setAttribute("msg", "用户添加成功");
				request.getRequestDispatcher("/admin/admin_add.jsp").forward(request, response);
			}
		}
	
	//用户登录
	void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收客户端传过来的数据
		String adminName=request.getParameter("adminName");
		String password=request.getParameter("password");
		
		//调用dao层进行效验
		AdminInfo admin=dao.safeLogin(adminName, password);
		
		if(admin!=null) {
			//将用户信息放到session作用域中
			request.getSession().setAttribute("g_admin", admin);
			request.getRequestDispatcher("/main.html").forward(request, response);
		}
		else {
			request.setAttribute("msg", "用户名或密码错误，请重新登陆");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	//注销退出
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//清空当前用户的session
		request.getSession().invalidate();
		response.getWriter().println("<script>window.top.location.href='login.jsp'</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
