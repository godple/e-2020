package com.wavus.service;

import java.net.URI;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

// maven spring-web 필요

public class H02HTTPService {

	public void request(String name) {
	    RestTemplate restClient = new RestTemplate();
	    
	    URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost").port(1880).path("test/1234")
	        .queryParam("name", name)
	        .build().toUri();
	    
	    String response = restClient.getForObject(uri, String.class);
	    
	    System.out.println(response);
	}
}
