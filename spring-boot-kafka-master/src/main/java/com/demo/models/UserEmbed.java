package com.demo.models;

public class UserEmbed extends User{

	private String role;
	private OtherDetails odtl;
	
	
	public UserEmbed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEmbed(String name, String dept, long salary, String role, OtherDetails odtl) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.role = role;
		this.odtl = odtl;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public OtherDetails getOdtl() {
		return odtl;
	}
	public void setOdtl(OtherDetails odtl) {
		this.odtl = odtl;
	}
	@Override
	public String toString() {
		return "UserEmbed [role=" + role + ", odtl=" + odtl.toString() + ", name=" + name + ", dept=" + dept + ", salary=" + salary
				+ "]";
	}
	
	
	
}
