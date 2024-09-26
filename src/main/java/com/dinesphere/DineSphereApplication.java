package com.dinesphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.dinesphere.entities")
public class DineSphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(DineSphereApplication.class, args);
	}

}
