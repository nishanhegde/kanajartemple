package com.Admin.bean;

public class CMSbean {

	private Integer Pid;

	private String Pagename;

	private String content;

	public String getPagename() {
		return Pagename;
	}

	public void setPagename(String pagename) {
		Pagename = pagename;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPid() {
		return Pid;
	}

	public void setPid(Integer pid) {
		Pid = pid;
	}
}
