package com.example.webMvcCrudDemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "BOOKS API", version = "1.0", description = "BOOKS Information"))
public class WebMvcCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebMvcCrudDemoApplication.class, args);
	}

}
