package com.microservice.elasticsearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ElasticsearchApplication {
	private static Logger logger = LoggerFactory.getLogger(ElasticsearchApplication.class);
	public static void main(String[] args) {
		logger.info("come in main");
		SpringApplication.run(ElasticsearchApplication.class, args);
	}
}
