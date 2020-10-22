package com.sam2021.sam2021;

import com.sam2021.sam2021.controller.HelloWorldController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sam2021Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldController.class, args);
	}

}
