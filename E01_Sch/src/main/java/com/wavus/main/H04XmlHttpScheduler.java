package com.wavus.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class H04XmlHttpScheduler {

	public static void main(String arg[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context4.xml");
	}
}
