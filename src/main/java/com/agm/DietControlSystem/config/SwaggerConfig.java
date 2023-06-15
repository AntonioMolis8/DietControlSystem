package com.agm.DietControlSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI dietControlSystemOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Diet Control System Open API")
						.description("Managing information about products and meals")
						.version("v1.0.0")
						.contact(new Contact().name("Antonio García Molis")
								.email("agm8dev@gmail.com")));
	}
}
