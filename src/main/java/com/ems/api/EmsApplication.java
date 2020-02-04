package com.ems.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EmsApplication {

	private static final Logger log = LoggerFactory.getLogger(EmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

}
