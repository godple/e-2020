package com.wavus.service;

import java.net.URI;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class H04HTTPSchService {
	
	private String name = "World";

	public void sayHello() {
		RestTemplate restClient = new RestTemplate();
	    
	    URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost").port(1880).path("test/1234")
	        .queryParam("name", name)
	        .build().toUri();
	    
	    String response = restClient.getForObject(uri, String.class);
	    
	    System.out.println("[Quartz] " + response);
	}
}
