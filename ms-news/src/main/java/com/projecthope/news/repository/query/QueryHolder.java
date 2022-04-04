package com.projecthope.news.repository.query;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "news")
@PropertySource(value = {"classpath:/queries/news.xml"})
public class QueryHolder {

    private Map<String, String> query;

    public String get(Queries queries) {
        return query.get(queries.getKey());
    }

}