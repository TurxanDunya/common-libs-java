package com.projecthope.news.repository.query;

public enum Queries {

    CREATE("create"),
    FIND_LAST_ADDED("lastAdded"),
    FIND_BY_ID("findById"),
    FIND_ALL("findAll");

    private final String key;

    Queries(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}