package com.projecthope.news.config.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties(prefix = "news")
public class NewsProperties {

    private Integer initialLimit;
    private Integer maxLimit;
    private Integer defaultOffset;

}