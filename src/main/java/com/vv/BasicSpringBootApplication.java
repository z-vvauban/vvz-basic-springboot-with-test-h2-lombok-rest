package com.vv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.vv.domain")
@EnableJpaRepositories("com.vv.repository")

public class BasicSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicSpringBootApplication.class, args);
	}

}
