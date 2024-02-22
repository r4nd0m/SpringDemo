package com.example.SpringDemo;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI springDemoOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("SpringBoot demo project REST API")
                .description("Demonstrates SpringBoot capabilities to build REST APIs")
                .version("1.0")
            );
    }
}