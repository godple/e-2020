package com.wavus.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wavus.service.H02HTTPService;

public class H02Http {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context2.xml");
		
		H02HTTPService service = context.getBean("sayHelloService", H02HTTPService.class);
		
		while(true) {
			service.request("Wrold");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
