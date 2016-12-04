package com.Admin.listner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.Admin.Service.EmailService;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.event.NithyaPoojeRejectEvent;

@Component
public class NithyaPoojeRejectListener implements ApplicationListener<NithyaPoojeRejectEvent> {

	@Autowired
<<<<<<< HEAD
	private EmailService emailService;

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void onApplicationEvent(NithyaPoojeRejectEvent paramE) {
		
		if (applicationContext.getParent()!=null) {
=======
	private kanajarTempleMethods defaultTempleMethods;

	@Autowired
	private EmailService emailService;

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void onApplicationEvent(NithyaPoojeRejectEvent paramE) {

		if (defaultTempleMethods.isChildApplicationContext(applicationContext)) {
>>>>>>> branch 'master' of https://github.com/nishanhegde/kanajartemple.git
			System.out.println("Reject event");
		}
	}
}
