package com.beans;

import java.util.List;

public class Class_Info {
	
	private int id;  
	private String class_Name;  
	private String des;    
	private int parentId;  
	private List<Class_Info> subClass_List;//该分类下的子分类
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClass_Name() {
		return class_Name;
	}
	public void setClass_Name(String class_Name) {
		this.class_Name = class_Name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public List<Class_Info> getSubClass_List() {
		return subClass_List;
	}
	public void setSubClass_List(List<Class_Info> subClass_List) {
		this.subClass_List = subClass_List;
	}
	@Override
	public String toString() {
		return "CateInfo [id=" + id + ", class_Name=" + class_Name + ", des=" + des + ", parentId=" + parentId
				+ ", subClass_List=" + subClass_List + "]";
	}
	
	
}