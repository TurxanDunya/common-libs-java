package com.projecthope.swagger.config;

import com.projecthope.swagger.config.properties.SwaggerConstants;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.projecthope.swagger.config.properties.SwaggerConstants.VERSION;

@Component
public class SwaggerDefinitionContext {

    private final ConcurrentHashMap<String, String> definitionMap;

    public SwaggerDefinitionContext() {
        this.definitionMap = new ConcurrentHashMap<>();
    }

    public void addServiceDefinitions(Map<String, String> definitions) {
        definitionMap.clear();
        definitionMap.putAll(definitions);
    }

    public String getSwaggerDefinition(String serviceName) {
        return this.definitionMap.get(serviceName);
    }

    public List<SwaggerResource> getSwaggerDefinitions() {
        return definitionMap.keySet().stream().map(key -> {
            SwaggerResource resource = new SwaggerResource();
            resource.setName(key);
            resource.setLocation("/definition/service/" + key);
            resource.setSwaggerVersion(VERSION);
            return resource;
        }).collect(Collectors.toList());
    }

}