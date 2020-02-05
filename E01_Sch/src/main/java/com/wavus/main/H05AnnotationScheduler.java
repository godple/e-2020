package com.wavus.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wavus.conf.H05Config;

public class H05AnnotationScheduler {

	public static void main(String arg[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(H05Config.class);
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("application-context5.xml");
		
	}
}
