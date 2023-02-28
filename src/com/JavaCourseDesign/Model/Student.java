package com.JavaCourseDesign.Model;

public class Student {
	private int id;
	private String name;
	private int cla_id;
	private String password;
	private String sex;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getCla_id() {
		return cla_id;
	}
	public void setCla_id(int cla_id) {
		this.cla_id=cla_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}
}
