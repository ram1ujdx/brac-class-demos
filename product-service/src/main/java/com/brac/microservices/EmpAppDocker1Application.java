package com.brac.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmpAppDocker1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmpAppDocker1Application.class, args);
	}

}
