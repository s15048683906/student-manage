package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.beans.AdminInfo;
import com.beans.MenuInfo;
import com.beans.RoleInfo;
import com.dao.AdminDao;
import com.dao.MenuDao;
import com.dao.RoleDao;

@WebServlet("/RoleServlet")

public class RoleServlet extends HttpServlet {

	RoleDao roleDao=new RoleDao();
	AdminDao adminDao=new AdminDao();
	MenuDao menuDao=new MenuDao();
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");
		
		if("add".equals(flag)) {
			add(request,response);
		}
		else if("manage".equals(flag)){
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
		else if("listAdmin".equals(flag)) {
			listAdmin(request,response);
		}
		else if("adminRole".equals(flag)) {
			adminRole(request,response);
		}
		else if("updateAdminRole".equals(flag)) {
			updateAdminRole(request,response);
		}
		else if("roleMenu".equals(flag)) {
			roleMenu(request,response);
		}
		else if("updateRoleMenu".equals(flag)) {
			updateRoleMenu(request,response);
		}
		
	}


	//用户添加
	void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//取客户端传过来的数据
		String roleName=request.getParameter("roleName");
		String des=request.getParameter("des");
		
		RoleInfo role= new RoleInfo();
		role.setRoleName(roleName);
		role.setDes(des);
		
		//调用dao层,进行数据操作, 并转向
		int result=roleDao.addRole(role);
		if(result==1) {
			request.setAttribute("msg", "角色添加成功");
			request.getRequestDispatcher("/role/role_add.jsp").forward(request, response);
		}
	}
	
	 //用户更新
		private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("id"));
			
			String roleName=request.getParameter("roleName");
			String des=request.getParameter("des");
			
			RoleInfo role=roleDao.getRoleById(id);
			role.setRoleName(roleName);
			role.setDes(des);
			
			int result=roleDao.updateRole(role);
			if(result==1) {
				request.setAttribute("msg", "更新成功");
				request.setAttribute("role", role);
				request.getRequestDispatcher("/role/role_update.jsp").forward(request, response);
			}
		}
	
	 //根据id查询用户信息，转到用户更新页面
	private void searchForUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		
		RoleInfo role=roleDao.getRoleById(id);
		request.setAttribute("role", role);
		request.getRequestDispatcher("/role/role_update.jsp").forward(request, response);
	}
	
	//查询所有用户，转到用户维护界面
	private void manage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RoleInfo> roleList=roleDao.getAllRoles();
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/role/role_manage.jsp").forward(request, response);
	}
	
	//查询所有的用户,转到用户权限分配页面
	private void listAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<AdminInfo> adminList= roleDao.getAllAdmin();
		request.setAttribute("adminList",adminList);
		request.getRequestDispatcher("/role/admin_list.jsp").forward(request, response);
		
	}
	
    //用户删除
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		int result=roleDao.deleteRoleById(id);
		
		if(result==1) {
			request.setAttribute("msg", "删除成功");
			
			manage(request,response);
		}
	}
	
	//根据用户id，查出用户信息，角色列表，转到用户角色分配页面
	private void adminRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		AdminInfo admin=adminDao.getAdminById(id);
		List<RoleInfo> roleList=roleDao.getAllRoles();
		
		request.setAttribute("admin", admin);
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/role/admin_role.jsp").forward(request, response);
		
	}
	
    //角色分配
	private void updateAdminRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adminId=Integer.parseInt(request.getParameter("adminId"));
		int roleId=Integer.parseInt(request.getParameter("roleId"));
		
		roleDao.updateAdminRole (adminId,roleId);
		
		request.setAttribute("msg", "角色更新成功");
		
		AdminInfo admin=adminDao.getAdminById(adminId);
		List<RoleInfo> roleList=roleDao.getAllRoles();
		
		request.setAttribute("admin", admin);
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/role/admin_role.jsp").forward(request, response);	
	}
	
	//查询出角色信息，菜单列表信息，转到菜单授权页面
	private void roleMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId=Integer.parseInt(request.getParameter("roleId"));
		RoleInfo role=roleDao.getRoleById(roleId);
		
		int parentId=0;
		List<MenuInfo> menuList=menuDao.getMenuList(parentId);
		 
		request.setAttribute("role",role);
		request.setAttribute("menuList",menuList);
		request.getRequestDispatcher("/role/role_menu.jsp").forward(request, response);
	}
	
	//真正给角色授权
	private void updateRoleMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId=Integer.parseInt(request.getParameter("roleId"));
		
		//取到勾选所有的复选框的值
		String[] menuIds=request.getParameterValues("menuIds");
		menuDao.addRoleMenu(roleId, menuIds);
		
		request.setAttribute("msg", "角色授权成功");
		
		//回显
		roleMenu(request,response);

	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				doGet(request, response);
	}
	
}
