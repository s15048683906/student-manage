package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.beans.MenuInfo;
import com.jdbc.MyBatisUtil;

//�Բ˵����й����dao
public class MenuDao {
	
	//���ݸ���id�ͽ�ɫid��ѯ
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
	
	//���ݸ���id��ѯ
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
	
	//����ɫ��Ȩ
	public void addRoleMenu(int roleId,String[] menuIds) {
		
		//�Ȱѽ�ɫԭ�е�Ȩ��ɾ��
		SqlSession s=MyBatisUtil.getSession();
		s.delete("menu.deleteRoleMenu",roleId);
		
		//������µ�Ȩ��
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
