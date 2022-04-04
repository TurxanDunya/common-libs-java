package com.projecthope.swagger.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfiguration {

    private final SwaggerDefinitionContext definitionContext;

    @Bean
    @Lazy
    @Primary
    public SwaggerResourcesProvider swaggerResourcesProvider() {
        return () -> new ArrayList<>(definitionContext.getSwaggerDefinitions());
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}