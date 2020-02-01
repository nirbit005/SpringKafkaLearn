package com.demo.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OtherDetails {
	
	private LocalDate doj;
	private LocalDateTime salCredTime;
	private String address;
	
	public OtherDetails(LocalDate doj, LocalDateTime salCredTime, String address) {
		super();
		this.doj = doj;
		this.salCredTime = salCredTime;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "OtherDetails [doj=" + doj + ", salCredTime=" + salCredTime + ", address=" + address + "]";
	}
	
	
}
