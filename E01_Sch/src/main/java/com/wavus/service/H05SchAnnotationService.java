package com.wavus.service;

import java.net.URI;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class H05SchAnnotationService {

	private String name = "world";

	public void request() {
		RestTemplate restClient = new RestTemplate();

		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost").port(1880).path("test/1234")
				.queryParam("name", name).build().toUri();

		String response = restClient.getForObject(uri, String.class);

		System.out.println(response);
	}
	
	// ===============================
	// 스케쥴러 - fixedDelay
	// ===============================
//	@Scheduled(fixedDelay = 5000)
//	public void sayHello() {
//		System.out.println("fixedDelay Now : " + System.currentTimeMillis());
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	// ===============================
	// 스케쥴러 - fixedRate
	// ===============================
	@Scheduled(fixedRate = 5000)
	public void sayHello() {
		System.out.println("fixedRate Now : " + System.currentTimeMillis());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ===============================
	// 스케쥴러 - cron
	// ===============================
	// @Scheduled(cron = "0/5 * * * * ?")
	// public void sayHello() {
	// this.request();
	//
	// }

}
