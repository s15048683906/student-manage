package com.beans;

public class AdminInfo {
	
	private  int id;
	private  int roleId;//��ɫid�����������ɫ�б�
	private  String note;
	private  String adminName;
	private  String password;
	private  String state;//�û�״̬
	private  String editDate;
	private  String roleName;//��ɫ���ƣ����ݿ���û������ֶΣ��ù�����ѯ�õ��� 
	
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
