package com.beans;

import java.util.List;

public class MenuInfo {
	private int id;
	private String menuName;
	private String url;
	private String icon;//图标
	private String target;//弹出位置
	private int parentId;//父级id
	List<MenuInfo> subMenuList;//子菜单
	
	public List<MenuInfo> getSubMenuList() {
		return subMenuList;
	}
	public void setSubMenuList(List<MenuInfo> subMenuList) {
		this.subMenuList = subMenuList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "MenuInfo [id=" + id + ", menuName=" + menuName + ", url=" + url + ", icon=" + icon + ", target="
				+ target + ", parentId=" + parentId + ", subMenuList=" + subMenuList + "]";
	}
	

}
