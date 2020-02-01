package com.demo.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public class UserDto {

	 private String name;
	 // private int age;
	 private String dept;
	 private long salary; 
	 private LocalDate doj;
	 private LocalDateTime salCredTime;
	 private Map<String, String> usrProfZoneResponsib;
	 
	 
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(String name, String dept, long salary, LocalDate doj, 
						LocalDateTime salCredTime, Map<String, String> usrProfZoneResponsib) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.doj = doj;
		this.salCredTime = salCredTime;
		this.usrProfZoneResponsib = usrProfZoneResponsib;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public LocalDateTime getSalCredTime() {
		return salCredTime;
	}
	public void setSalCredTime(LocalDateTime salCredTime) {
		this.salCredTime = salCredTime;
	}
	
	public Map<String, String> getUsrProfZoneResponsib() {
		return usrProfZoneResponsib;
	}

	public void setUsrProfZoneResponsib(Map<String, String> usrProfZoneResponsib) {
		this.usrProfZoneResponsib = usrProfZoneResponsib;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", dept=" + dept + ", salary=" + salary + ", doj=" + doj + ", salCredTime="
				+ salCredTime + ", usrProfZoneResponsib=" + usrProfZoneResponsib + "]";
	}

	
	 	 
}
