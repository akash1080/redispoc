package com.example.redispoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class RedispocApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedispocApplication.class, args);
	}

}
