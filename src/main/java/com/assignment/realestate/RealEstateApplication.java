package com.assignment.realestate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Real Estate Management APIs", version = "v1"))
@SpringBootApplication
public class RealEstateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		final String securitySchemeName = "bearerAuth";
		return new OpenAPI()
				.components(
						new Components()
								.addSecuritySchemes(securitySchemeName,
										new SecurityScheme()
												.type(SecurityScheme.Type.HTTP)
												.scheme("bearer")
												.bearerFormat("JWT")
								)
				)
				.security(List.of(new SecurityRequirement().addList(securitySchemeName)))
				.info(new Info().title("Real Estate Management APIs").version("v1"));
	}

}
