package com.projecthope.swagger.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.projecthope.swagger.config.properties.SwaggerProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static com.projecthope.swagger.config.properties.SwaggerConstants.BASE_PATH;
import static com.projecthope.swagger.config.properties.SwaggerConstants.EMPTY_DEFINITION;
import static com.projecthope.swagger.config.properties.SwaggerConstants.HOST;

@Slf4j
@Component
@RequiredArgsConstructor
public class SwaggerDefinitionUpdater {

    private final SwaggerProperties swaggerProperties;
    private final SwaggerDefinitionContext definitionContext;
    private final RestTemplate template;
    private final ObjectMapper mapper;

    @Scheduled(fixedDelayString = "${application.swagger.refresh-interval}")
    public void refreshSwaggerConfigurations() {
        log.debug("Starting Swagger Definition Updater");

        final Map<String, String> tempDefinitionMap = new LinkedHashMap<>();

        swaggerProperties.getDefinitions().forEach(definition -> {
            String serviceName = definition.getName();
            Optional<String> definitionJsonData = fetchSwaggerDefinition(serviceName, definition.getUrl());

            if (definitionJsonData.isPresent()) {
                Optional<String> modifiedData =
                        modifyDefinitionData(definitionJsonData.get(), definition.getBasePath(), serviceName);
                modifiedData.ifPresent(json -> tempDefinitionMap.put(serviceName, json));
            } else {
                log.warn("Could not get [{}] swagger definition from API, so adding empty definition", serviceName);
                tempDefinitionMap.put(serviceName, EMPTY_DEFINITION);
            }
        });

        definitionContext.addServiceDefinitions(tempDefinitionMap);
        tempDefinitionMap.clear();

        log.debug("Swagger Definition Updater ended");
    }

    private Optional<String> fetchSwaggerDefinition(String serviceName, String url) {
        try {
            String apiDocsAsJson = template.getForObject(url, String.class);
            return Optional.ofNullable(apiDocsAsJson);
        } catch (RestClientException ex) {
            log.error("{} - error occurs while getting definition for service {}", ex.getMessage(), serviceName, ex);
            return Optional.empty();
        }
    }

    private Optional<String> modifyDefinitionData(String json, String basePath, String serviceName) {
        try {
            ObjectNode objectNode = (ObjectNode) mapper.readTree(json);
            objectNode.put(HOST, swaggerProperties.getHost());
            objectNode.put(BASE_PATH, basePath);
            return Optional.of(objectNode.toString());
        } catch (JsonProcessingException ex) {
            log.error("{} - error occurs while modify definition for service {}", ex.getMessage(), serviceName, ex);
            return Optional.empty();
        }
    }

}