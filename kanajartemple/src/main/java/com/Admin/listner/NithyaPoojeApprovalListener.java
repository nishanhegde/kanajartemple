package com.Admin.listner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.Admin.Service.EmailService;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.event.NithyaPoojeApprovalEvent;

@Component
public class NithyaPoojeApprovalListener
		implements ApplicationListener<NithyaPoojeApprovalEvent> {

	  
	@Autowired
	private EmailService emailService;

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private kanajarTempleMethods defaultTempleMethods;

	@Override
	public void onApplicationEvent(NithyaPoojeApprovalEvent event) {

		if(defaultTempleMethods.isChildApplicationContext(applicationContext))
		{
		System.out.println("Approve event" + event.getSource() + "=" + event.getClass());

		}
	}

	

}
