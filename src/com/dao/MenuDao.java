package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.beans.MenuInfo;
import com.jdbc.MyBatisUtil;

//对菜单进行管理的dao
public class MenuDao {
	
	//根据父级id和角色id查询
	public List<MenuInfo> getMenuList(int parentId,int roleId){
		SqlSession s=MyBatisUtil.getSession();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("parentId", parentId);
		map.put("roleId", roleId);
		
		List<MenuInfo> menuList=s.selectList("menu.getRoleMenuList",map);
		
		for(MenuInfo m: menuList) {
			if(m.getParentId()==0) {
				m.setSubMenuList(getMenuList(m.getId(),roleId));
			}
		}
		
		MyBatisUtil.close(s);
		return menuList;
	}
	
	//根据父级id查询
	public List<MenuInfo> getMenuList(int parentId){
		SqlSession s=MyBatisUtil.getSession();
		List<MenuInfo> menuList=s.selectList("menu.getMenuList",parentId);
		
		for(MenuInfo m: menuList) {
			if(m.getParentId()==0) {
				m.setSubMenuList(getMenuList(m.getId()));
			}
		}
		
		MyBatisUtil.close(s);
		return menuList;
	}
	
	//给角色授权
	public void addRoleMenu(int roleId,String[] menuIds) {
		
		//先把角色原有的权限删除
		SqlSession s=MyBatisUtil.getSession();
		s.delete("menu.deleteRoleMenu",roleId);
		
		//再添加新的权限
		for(String menuId: menuIds) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("roleId", roleId);
			map.put("menuId", menuId);
			s.insert("menu.addRoleMenu",map);
		}
		
		s.commit();
		MyBatisUtil.close(s);

	}

}
