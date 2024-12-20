package com.rasysbox.central.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Central Service");
        Contact contact = new Contact();
        contact.setEmail("rasysbox@hotmail.com");
        contact.setName("Raul Bolivar Navas");
        contact.setUrl("https://www.rasysbox.com");
        License mitLicense = new License()
                .name("MIT License")
                .url("https://www.rasysbox.com/License");
        Info info = new Info()
                .title("Central Service")
                .version("1.0")
                .contact(contact)
                .description("Central Service")
                .termsOfService("Terms Of Service")
                .license(mitLicense);
        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer));
    }
}
