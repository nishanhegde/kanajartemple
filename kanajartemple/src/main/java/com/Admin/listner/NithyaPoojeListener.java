package com.Admin.listner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.Admin.Service.EmailService;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.event.NithyaPoojeEvent;
import com.Admin.event.NithyaPoojeRejectEvent;

@Component
public class NithyaPoojeListener implements ApplicationListener<NithyaPoojeEvent> {

	private static final Logger logger = Logger.getLogger(NithyaPoojeListener.class);

	@Value("${email.from}")
	private String from;
	
	@Value("${website.url}")
	private String website;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;

	@Override
	public void onApplicationEvent(NithyaPoojeEvent event) {

		try {
			final SashwathaPoojebean sashwathaPooje = event.getSashwathaPoojebean();

			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					
					message.setTo(sashwathaPooje.getEmail());
					message.setFrom(from);
					message.setSubject("Nithya Pooje Information");
					Map model = new HashMap();
					model.put("pooje", sashwathaPooje);
					model.put("date", getConvertedDate(new Date()));
					model.put("url", website + "/nithyapooje");
					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
							"./EmailTemplates/nithyapooje.vm","utf-8", model);
					message.setText(text, true);
				}
			};
			mailSender.send(preparator);
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	private String getConvertedDate(final Date date)
	{
		final String pattern = "dd-MM-YYYY";
		final SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}


}
