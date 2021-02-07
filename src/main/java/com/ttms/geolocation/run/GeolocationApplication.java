package com.ttms.geolocation.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ttms.geolocation.*"})
public class GeolocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeolocationApplication.class, args);
	}

}
