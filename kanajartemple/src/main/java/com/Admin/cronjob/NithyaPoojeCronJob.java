package com.Admin.cronjob;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NithyaPoojeCronJob {
	
	@Scheduled(cron="${nithyapooje.cronjob.expression}")
    public void triggerJob()
    {
        System.out.println("Method executed 5 PM . Current time is :: "+ new Date());
    }

}
