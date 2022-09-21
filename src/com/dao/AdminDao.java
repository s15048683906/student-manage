package com.dao;

import java.sql.*;
import java.util.*;
import com.beans.AdminInfo;
import com.jdbc.DBUtil;

public class AdminDao {
	
	//安全登录
	public AdminInfo safeLogin(String adminName,String password){
		AdminInfo admin=null;
		Connection conn=null;
		PreparedStatement stm=null;  
		ResultSet rs=null;
		
		try {
				conn=DBUtil.getConn();
				String sql="select * from admininfo where adminName=? and password=? "; 
				stm=conn.prepareStatement(sql);  
				stm.setString(1, adminName);
				stm.setString(2, password);
				
				rs=stm.executeQuery();
				
				if(rs.next()){
					admin=new AdminInfo();
					
					admin.setId(rs.getInt("id"));
					admin.setNote(rs.getString("note"));
					admin.setPassword(rs.getString("password"));
					admin.setAdminName(rs.getString("adminName"));
					admin.setState(rs.getString("state"));
					admin.setRoleId(rs.getInt("roleId"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, stm, conn);
		}
		
		return admin;	
		
	}
	
	/**
	 * 用户添加
	 * @param admin 用户信息实体类
	 * @return 成功返回1
	 */
	public int addAdmin(AdminInfo admin) {
		int result=0;
		Connection conn=null;
		PreparedStatement stm=null;
		try {
			conn=DBUtil.getConn();
			String sql="insert into adminInfo (adminname,password,note,roleId,state) values(?,?,?,?,?)";
			stm=conn.prepareStatement(sql);
			stm.setObject(1, admin.getAdminName());
			stm.setObject(2, admin.getPassword());
			stm.setObject(3, admin.getNote());
			stm.setObject(4,admin.getRoleId());
			stm.setObject(5, admin.getState());
			result=stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stm, conn);
		}
		return result;
	}
       //查询所有用户 
	public List<AdminInfo> getAllAdmin() {
		List<AdminInfo> adminList=new ArrayList<AdminInfo>();
			
			Connection conn=null;
			PreparedStatement stm=null;
			ResultSet rs=null;

			try {
				conn=DBUtil.getConn();
				String sql="select * from adminInfo";
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
					
					adminList.add(admin);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUtil.close(rs, stm, conn);
			}

		return adminList;
	}
		
    //查询用户信息     
	public AdminInfo getAdminById(int id) {
		AdminInfo admin=null;
		Connection conn=null;
		PreparedStatement stm=null;  
		ResultSet rs=null;
		
		try {
				conn=DBUtil.getConn();
				String sql="select * from admininfo where id=? "; 
				stm=conn.prepareStatement(sql);  
				stm.setInt(1, id);
				
				rs=stm.executeQuery();
				if(rs.next()){
					admin=new AdminInfo();
					admin.setId(rs.getInt("id"));
					admin.setNote(rs.getString("note"));
					admin.setPassword(rs.getString("password"));
					admin.setAdminName(rs.getString("adminName"));
					admin.setState(rs.getString("state"));
					admin.setRoleId(rs.getInt("roleId"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, stm, conn);
		}
		
		return admin;	
	}
	
	//修改用户
	public int updateAdmin(AdminInfo admin) {
		int result=0;
		Connection conn=null;
		PreparedStatement stm=null;
		try {
			conn=DBUtil.getConn();
			String sql="update adminInfo set adminName=?, password=?, note=?, roleId=?, state=? where id=?";
			stm=conn.prepareStatement(sql);
			stm.setObject(1, admin.getAdminName());
			stm.setObject(2, admin.getPassword());
			stm.setObject(3, admin.getNote());
			stm.setObject(4,admin.getRoleId());
			stm.setObject(5, admin.getState());
			stm.setObject(6, admin.getId());
			result =stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(null, stm, conn);
		}
		return result;
	}
	//用户删除
	public int deleteAdminById(int id) {
		int result=0;
		Connection conn=null;
		PreparedStatement stm=null;
		try {
			conn=DBUtil.getConn();
			String sql="delete from admininfo where id=?";
			stm=conn.prepareStatement(sql);
			stm.setInt(1, id);
			result= stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(null, stm, conn);
		}
		return result;
	}

}
