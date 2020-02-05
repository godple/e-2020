package com.wavus.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wavus.service.H01SchService;


public class H01Sch {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context1.xml");
		
		H01SchService service = context.getBean("sayHelloService", H01SchService.class);
		
		while(true) {
			System.out.println(service.sayHello("World") + System.currentTimeMillis());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
