package com.projecthope.content.config;

import com.projecthope.content.config.properties.MinioProperties;
import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfiguration {

    private final String accessKey;
    private final String secretKey;
    private final String url;

    public MinioConfiguration(MinioProperties minioProperties) {
        this.url = minioProperties.getUrl();
        this.accessKey = minioProperties.getAccessKey();
        this.secretKey = minioProperties.getSecretKey();
    }

    @Bean("news")
    public MinioClient clientNews() {
        return MinioClient.builder()
                .credentials(accessKey, secretKey)
                .endpoint(url)
                .build();
    }

}