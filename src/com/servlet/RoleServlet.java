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


	//�û����
	void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ȡ�ͻ��˴�����������
		String roleName=request.getParameter("roleName");
		String des=request.getParameter("des");
		
		RoleInfo role= new RoleInfo();
		role.setRoleName(roleName);
		role.setDes(des);
		
		//����dao��,�������ݲ���, ��ת��
		int result=roleDao.addRole(role);
		if(result==1) {
			request.setAttribute("msg", "��ɫ��ӳɹ�");
			request.getRequestDispatcher("/role/role_add.jsp").forward(request, response);
		}
	}
	
	 //�û�����
		private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("id"));
			
			String roleName=request.getParameter("roleName");
			String des=request.getParameter("des");
			
			RoleInfo role=roleDao.getRoleById(id);
			role.setRoleName(roleName);
			role.setDes(des);
			
			int result=roleDao.updateRole(role);
			if(result==1) {
				request.setAttribute("msg", "���³ɹ�");
				request.setAttribute("role", role);
				request.getRequestDispatcher("/role/role_update.jsp").forward(request, response);
			}
		}
	
	 //����id��ѯ�û���Ϣ��ת���û�����ҳ��
	private void searchForUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		
		RoleInfo role=roleDao.getRoleById(id);
		request.setAttribute("role", role);
		request.getRequestDispatcher("/role/role_update.jsp").forward(request, response);
	}
	
	//��ѯ�����û���ת���û�ά������
	private void manage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RoleInfo> roleList=roleDao.getAllRoles();
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/role/role_manage.jsp").forward(request, response);
	}
	
	//��ѯ���е��û�,ת���û�Ȩ�޷���ҳ��
	private void listAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<AdminInfo> adminList= roleDao.getAllAdmin();
		request.setAttribute("adminList",adminList);
		request.getRequestDispatcher("/role/admin_list.jsp").forward(request, response);
		
	}
	
    //�û�ɾ��
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		int result=roleDao.deleteRoleById(id);
		
		if(result==1) {
			request.setAttribute("msg", "ɾ���ɹ�");
			
			manage(request,response);
		}
	}
	
	//�����û�id������û���Ϣ����ɫ�б�ת���û���ɫ����ҳ��
	private void adminRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		AdminInfo admin=adminDao.getAdminById(id);
		List<RoleInfo> roleList=roleDao.getAllRoles();
		
		request.setAttribute("admin", admin);
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/role/admin_role.jsp").forward(request, response);
		
	}
	
    //��ɫ����
	private void updateAdminRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adminId=Integer.parseInt(request.getParameter("adminId"));
		int roleId=Integer.parseInt(request.getParameter("roleId"));
		
		roleDao.updateAdminRole (adminId,roleId);
		
		request.setAttribute("msg", "��ɫ���³ɹ�");
		
		AdminInfo admin=adminDao.getAdminById(adminId);
		List<RoleInfo> roleList=roleDao.getAllRoles();
		
		request.setAttribute("admin", admin);
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/role/admin_role.jsp").forward(request, response);	
	}
	
	//��ѯ����ɫ��Ϣ���˵��б���Ϣ��ת���˵���Ȩҳ��
	private void roleMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId=Integer.parseInt(request.getParameter("roleId"));
		RoleInfo role=roleDao.getRoleById(roleId);
		
		int parentId=0;
		List<MenuInfo> menuList=menuDao.getMenuList(parentId);
		 
		request.setAttribute("role",role);
		request.setAttribute("menuList",menuList);
		request.getRequestDispatcher("/role/role_menu.jsp").forward(request, response);
	}
	
	//��������ɫ��Ȩ
	private void updateRoleMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId=Integer.parseInt(request.getParameter("roleId"));
		
		//ȡ����ѡ���еĸ�ѡ���ֵ
		String[] menuIds=request.getParameterValues("menuIds");
		menuDao.addRoleMenu(roleId, menuIds);
		
		request.setAttribute("msg", "��ɫ��Ȩ�ɹ�");
		
		//����
		roleMenu(request,response);

	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				doGet(request, response);
	}
	
}
