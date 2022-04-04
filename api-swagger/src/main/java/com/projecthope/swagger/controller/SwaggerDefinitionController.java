package com.projecthope.swagger.controller;

import com.projecthope.swagger.config.SwaggerDefinitionContext;
import com.projecthope.swagger.config.SwaggerDefinitionUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SwaggerDefinitionController {

    private final SwaggerDefinitionContext definitionContext;
    private final SwaggerDefinitionUpdater swaggerDefinitionUpdater;

    @GetMapping("/definition/service/{serviceName}")
    public String getServiceDefinition(@PathVariable("serviceName") String serviceName) {
        return definitionContext.getSwaggerDefinition(serviceName);
    }

    @PutMapping("/definition/refresh")
    public void refreshServiceDefinitions() {
        swaggerDefinitionUpdater.refreshSwaggerConfigurations();
    }

}
