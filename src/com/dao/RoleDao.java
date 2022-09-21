package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.beans.AdminInfo;
import com.beans.RoleInfo;
import com.jdbc.DBUtil;
import com.jdbc.MyBatisUtil;

public class RoleDao {
	
	//添加角色
	public int addRole(RoleInfo role) {	
		SqlSession s=MyBatisUtil.getSession();
		int result=s.insert("role.addRole",role);
		
		//注意一定要提交事务
		s.commit();  	
		s.close();
		
		return result;	
	}
	
	//删除角色
	public int deleteRoleById(int id) {
		SqlSession s=MyBatisUtil.getSession();
		int result=s.delete("role.deleteRoleById",id);
		s.commit();  	
		s.close();
		
		return result;	
	}
	
	
	//更新角色
	public int updateRole(RoleInfo role) {
		SqlSession s=MyBatisUtil.getSession();
		int result=s.update("role.updateRole",role);
		s.commit();  	
		s.close();
		return result;
	}

	//根据id查询
	public RoleInfo getRoleById(int id) {
		SqlSession s=MyBatisUtil.getSession();
		RoleInfo role=s.selectOne("role.getRoleById",id);
		s.close();
		return role;
	}
			
			
	//查询所有角色
	public List<RoleInfo> getAllRoles(){
		SqlSession s=MyBatisUtil.getSession();
		List<RoleInfo> roleList=s.selectList("role.getAllRoles");
		s.close();
		return  roleList;
	}

	
	public List<AdminInfo> getAllAdmin() {
		List<AdminInfo> adminList=new ArrayList<AdminInfo>();
			
		Connection conn=null;
		PreparedStatement stm=null;
		ResultSet rs=null;

		try {
			conn=DBUtil.getConn();
			String sql="select a.*, b.roleName from adminInfo a left join roleInfo b  on a.roleId=b.id";
			stm=conn.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()) {
				AdminInfo admin=new AdminInfo();
				admin.setId(rs.getInt("id"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setPassword(rs.getString("password"));
				admin.setNote(rs.getString("note"));
				admin.setRoleId(rs.getInt("roleId"));
				admin.setState(rs.getString("state"));
				admin.setRoleName(rs.getString("roleName"));
				adminList.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stm, conn);
		}

		return adminList;
	}

	//更新用户角色
	public int updateAdminRole(int adminId, int roleId) {
		SqlSession s=MyBatisUtil.getSession();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("roleId", roleId);
		map.put("adminId", adminId);
		
		int result=s.update("role.updateAdminRole",map);
		s.commit();
		
		return result;
	}
}
