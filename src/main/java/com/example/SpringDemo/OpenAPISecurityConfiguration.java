package com.example.SpringDemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info =@Info(
        title = "User API",
        version = "1.0",
        contact = @Contact(
            name = "Vladimir", email = "vladimir@donotwritemeiwillnoanswer.com"
        ),
        license = @License(
            name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
        ),
        description = "Demo REST API using SpringBoot"
    ),
    servers = @Server(
        url = "http://localhost:8080/",
        description = "Development"
    )
)
public class OpenAPISecurityConfiguration {}