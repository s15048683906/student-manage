package com.beans;

public class StudentInfo {
	private int id;
	private String password;  //��¼ѧ������Ϣϵͳʱ�ã��������ڱ�ϵͳ��¼
	private String studentName;  
	private String sex;  
	private String major;  
	private String class_;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}
	
	@Override
	public String toString() {
		return "StudentInfo [id=" + id + ", password=" + password + ", studentName=" + studentName + ", sex=" + sex
				+ ", major=" + major + ", class_=" + class_ + "]";
	}  

} 
