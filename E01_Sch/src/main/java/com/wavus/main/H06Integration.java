package com.wavus.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class H06Integration {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context6.xml");
	}

}
