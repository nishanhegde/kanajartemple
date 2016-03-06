package com.Admin.bean;

import java.sql.Timestamp;

public class Poojebean {

	private Integer SI;
	private Integer RecNo;
	private String Name;
	private Integer Quantity;
	private Integer Pid;
	private String PDate;
	private Timestamp BDate;

	public String getPDate() {
		return PDate;
	}

	public void setPDate(String pDate) {
		PDate = pDate;
	}

	public Integer getSI() {
		return SI;
	}

	public void setSI(Integer sI) {
		SI = sI;
	}

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

	public Integer getPid() {
		return Pid;
	}

	public void setPid(Integer pid) {
		Pid = pid;
	}

	public Timestamp getBDate() {
		return BDate;
	}

	public void setBDate(Timestamp bDate) {
		BDate = bDate;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

}
