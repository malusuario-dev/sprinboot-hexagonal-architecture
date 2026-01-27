package com.camilo.webdemo.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

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
public class OpenAPIConfif {
}
