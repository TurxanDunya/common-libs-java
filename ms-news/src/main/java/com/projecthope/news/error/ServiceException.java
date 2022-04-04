package com.projecthope.news.error;

import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class ServiceException extends RuntimeException {

    private String errorUuid;
    private String errorCode;
    private String errorMessage;
    private Map<String, Object> properties = new HashMap<>();

    public ServiceException(String errorUuid, String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorUuid = errorUuid;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ServiceException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorUuid = UUID.randomUUID().toString();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static ServiceException of(ErrorCodes errorCode, String errorMessage) {
        return new ServiceException(errorCode.code(), errorMessage);
    }

    public ServiceException set(String name, Object value) {
        properties.put(name, value);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T) properties.get(name);
    }

    public boolean is(ErrorCodes errorCode) {
        return errorCode != null && errorCode.code().equals(this.errorCode);
    }

    public String formatProperties() {
        return Optional.ofNullable(properties)
                .map(Map::keySet)
                .orElse(Collections.emptySet())
                .stream()
                .map(this::formatProperty)
                .collect(Collectors.joining(", "));
    }

    private String formatProperty(String key) {
        return key + ": " + properties.get(key);
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }

}