package com.shopingCart.crons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shopingCart.revinewPack.RevinewService;

@Component
@EnableAsync
@EnableScheduling
public class CronsController {
	@Autowired
	RevinewService revinewService;

	@Scheduled(cron = "*/5 * * * * ?")
	public void saveReportsGenerate() {
		revinewService.updateRevinew();
	}
	

	//

	
	
	
	
	
	
	
	
	// every one mins
	// @Scheduled(cron="*/1 * * * * ?")
	public void saveReportsGenerate1() {
		revinewService.updateRevinew();
	}

}
