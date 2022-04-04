package com.projecthope.news.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "news-paging")
public class NewsProperties {

    private Integer initialLimit;
    private Integer maxLimit;
    private Integer defaultOffset;

}