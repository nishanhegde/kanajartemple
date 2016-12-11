package com.Admin.listner;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.Admin.Service.EmailService;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.Service.Impl.AdminHomeService;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.event.NithyaPoojeApprovalEvent;

@Component

public class NithyaPoojeApprovalListener implements ApplicationListener<NithyaPoojeApprovalEvent> {

	private static final Logger logger = Logger.getLogger(NithyaPoojeApprovalListener.class);

	@Value("${email.from}")
	private String from;

	@Value("${website.url}")
	private String website;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;

	@Override
	public void onApplicationEvent(NithyaPoojeApprovalEvent event) {

		try {
			final SashwathaPoojebean sashwathaPooje = event.getSashwathaPoojebean();

			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
					message.setTo(sashwathaPooje.getEmail());
					message.setFrom(from);
					message.setSubject("Nithya Pooje Information");
					Map model = new HashMap();
					model.put("pooje", sashwathaPooje);
					model.put("url", website + "/nithyapooje");
					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
							"./EmailTemplates/nithyapoojeapproval.vm", model);
					message.setText(text, true);
				}
			};
			mailSender.send(preparator);
		} catch (Exception e) {
			logger.error(e);
		}
	}

}
