package com.projecthope.content.config;

import com.projecthope.content.model.ContentClientBucket;
import io.minio.MinioClient;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class MinioClientFactory {

    private static final Map<ContentClientBucket, MinioClient> clients = new HashMap<>();

    public MinioClientFactory(ApplicationContext context) {
        Stream.of(context.getBeanNamesForType(MinioClient.class)).forEach(bucket -> clients.put(
                ContentClientBucket.of(bucket), context.getBean(bucket, MinioClient.class)));
    }

    public static MinioClient getMinioClient(ContentClientBucket bucket) {
        return clients.get(bucket);
    }

}