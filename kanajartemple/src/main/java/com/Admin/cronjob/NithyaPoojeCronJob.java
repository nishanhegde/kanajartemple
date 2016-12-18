package com.Admin.cronjob;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.Admin.Service.Impl.PoojeService;
import com.Admin.listner.NithyaPoojeApprovalListener;

@Service
public class NithyaPoojeCronJob {

	private static final Logger logger = Logger.getLogger(NithyaPoojeCronJob.class);
	
	@Autowired
	private PoojeService poojeService;

	@Scheduled(cron = "${nithyapooje.cronjob.expression}")
	public void triggerJob() {
		
			logger.info("Nithya Pooje cron job triggered at :: " + new Date());
			
			poojeService.sendNithyaPoojeEmail();
	}

}
