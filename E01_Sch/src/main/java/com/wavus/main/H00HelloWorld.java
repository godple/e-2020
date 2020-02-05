package com.wavus.main;

import com.wavus.service.H00HelloWorldService;

public class H00HelloWorld {

	public static void main(String arg[]) {
		
		H00HelloWorldService service = new H00HelloWorldService();
		
		while(true) {
			System.out.println(service.sayHello("World"));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
