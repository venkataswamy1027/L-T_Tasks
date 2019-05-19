package com.lnt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication {
	private static final Logger logger = LoggerFactory.getLogger(RestApiApplication.class);
	public static void main(String[] args) {
		logger.info("Entering into main method {}", System.currentTimeMillis());
		SpringApplication.run(RestApiApplication.class, args);
	}
}
