package com.sample.server.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        OpenAPI openAPI = new OpenAPI()
            .info(apiInfo())
            .externalDocs(new ExternalDocumentation()
                .description("README file")
                .url("https://github.com/cortiz37/simple-rest-ws/blob/main/README.md"));

        return openAPI;
    }

    private Info apiInfo() {
        return new Info().title("SpringBoot - Simple Rest API")
            .description("" +
                "Simple REST API for demonstration purposes.<br/><br/>" +
                "Basic operations over `Element` entity." +
                "")
            .version("1.0");
    }
}
