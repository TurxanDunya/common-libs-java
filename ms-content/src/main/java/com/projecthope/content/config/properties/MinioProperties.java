package com.projecthope.content.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("spring.minio")
public class MinioProperties {

    private String accessKey;
    private String secretKey;
    private String url;
    private String bucket;

}