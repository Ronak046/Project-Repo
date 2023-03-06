package com.gl.OrderService2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OrderService2Application {

	public static void main(String[] args) {
		SpringApplication.run(OrderService2Application.class, args);
	}

}
