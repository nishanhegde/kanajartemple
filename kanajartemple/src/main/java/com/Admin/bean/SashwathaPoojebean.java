package com.Admin.bean;


import java.sql.Timestamp;



public class SashwathaPoojebean {
	
	private Integer RecNo;
	private String Name;
	private String Address;
	private String MobileNo;
	private String Email;
	private Timestamp Bdate;
	private String Pdate;
	private Integer Pid;
		
	public Integer getRecNo() {
		return RecNo;
	}
	public void setRecNo(Integer recNo) {
		RecNo = recNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public Timestamp getBdate() {
		return Bdate;
	}
	public void setBdate(Timestamp bdate) {
		Bdate = bdate;
	}
	public Integer getPid() {
		return Pid;
	}
	public void setPid(Integer pid) {
		Pid = pid;
	}
	public String getPdate() {
		return Pdate;
	}
	public void setPdate(String pdate) {
		Pdate = pdate;
	}
	
	
	
}
