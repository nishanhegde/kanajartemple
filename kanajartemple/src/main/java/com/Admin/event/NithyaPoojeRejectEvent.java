package com.Admin.event;

import org.springframework.context.ApplicationEvent;

import com.Admin.bean.SashwathaPoojebean;

public class NithyaPoojeRejectEvent extends ApplicationEvent  {

	private SashwathaPoojebean sashwathaPoojebean;
	
	public NithyaPoojeRejectEvent(Object source, SashwathaPoojebean sashwathaPoojebean) {
		super(source);
		this.sashwathaPoojebean = sashwathaPoojebean;
	}

	public SashwathaPoojebean getSashwathaPoojebean() {
		return sashwathaPoojebean;
	}
}
