package com.Admin.bean;

import java.sql.Timestamp;

public class DonationDetail {
	
	private Integer SI;
	private Integer RecNO;
	private String Name;
	private String Address;
	private Double Amount;
	private String MobileNO;
	private String Email;
	private Timestamp Bdate;
	private Integer Did;
	public Integer getSI() {
		return SI;
	}
	public void setSI(Integer sI) {
		SI = sI;
	}
	public Integer getRecNO() {
		return RecNO;
	}
	public void setRecNO(Integer recNO) {
		RecNO = recNO;
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
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public String getMobileNO() {
		return MobileNO;
	}
	public void setMobileNO(String mobileNO) {
		MobileNO = mobileNO;
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
	public Integer getDid() {
		return Did;
	}
	public void setDid(Integer did) {
		Did = did;
	}
	

}
