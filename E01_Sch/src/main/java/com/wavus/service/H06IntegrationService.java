package com.wavus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wavus.gw.RequestGateway;

@Component
public class H06IntegrationService {

	@Autowired
	ApplicationContext context;
	// ===============================
	// 스케쥴러 - cron
	// ===============================
	@Scheduled(cron = "0/5 * * * * ?")
	public void request() {
		RequestGateway requestGateway = context.getBean("requestGateway", RequestGateway.class);
		String reply = requestGateway.echo("Hello");
		System.out.println("[Integration] [Server } :" + reply);
	}
}
