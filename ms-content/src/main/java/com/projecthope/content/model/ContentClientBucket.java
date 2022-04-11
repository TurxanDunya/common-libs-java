package com.projecthope.content.model;

import java.util.stream.Stream;

public enum ContentClientBucket {

    NEWS("news");

    private final String bucket;

    ContentClientBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }

    public static ContentClientBucket of(String bucket) {
        return Stream.of(ContentClientBucket.values())
                .filter(clientBucket -> clientBucket.bucket.equals(bucket))
                .findFirst()
                .orElse(null);
    }

}
