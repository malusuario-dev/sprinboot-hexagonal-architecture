package com.camilo.webdemo.common.infrastriture.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Product API",
                version = "1.0.0",
                description = "API REST desarrollada con Spring Boot, arquitectura hexagonal y Clean Architecture.",
                contact = @Contact(
                        name = "Juan Camilo Sanabrisa Vargas",
                        email = "juancamilo.sanabrisa@email.com",
                        url = "https://github.com/malusuario-dev"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        )
)

@SecurityScheme(name = "Bearer Authentication",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        description = "Authentication with JWT")


@Configuration
public class OpenAPIConfif {
}
