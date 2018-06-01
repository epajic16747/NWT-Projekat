package com.nwtProject.OAuth2Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class OAuth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ServerApplication.class, args);
	}
	@RequestMapping(
	        value = "/",
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<String> index() {
	    return new ResponseEntity<>("{\"message\":\"Home!\"}", HttpStatus.OK);
	}	
}


