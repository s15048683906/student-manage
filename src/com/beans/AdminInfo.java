package com.beans;

public class AdminInfo {
	
	private  int id;
	private  int roleId;//角色id，会关联到角色列表
	private  String note;
	private  String adminName;
	private  String password;
	private  String state;//用户状态
	private  String editDate;
	private  String roleName;//角色名称（数据库中没有这个字段，用关联查询得到） 
	
	@Override
	public String toString() {
		return "AdminInfo [id=" + id + ", roleld=" + roleId + ", note=" + note + ", adminName=" + adminName
				+ ", password=" + password + ", state=" + state + ", editDate=" + editDate + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}
