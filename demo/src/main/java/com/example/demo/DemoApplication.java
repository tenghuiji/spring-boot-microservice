package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@RestController
public class DemoApplication {
	private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		logger.info("come in main");
		SpringApplication.run(DemoApplication.class, args);
	}
}
