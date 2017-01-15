package com.Admin.bean;

import org.springframework.beans.factory.annotation.Value;

public class Coupon {

	private Integer noFrom;
	private Integer noTo;
	private String title;

	public Integer getNoFrom() {
		return noFrom;
	}

	public void setNoFrom(Integer noFrom) {
		this.noFrom = noFrom;
	}

	public Integer getNoTo() {
		return noTo;
	}

	public void setNoTo(Integer noTo) {
		this.noTo = noTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
