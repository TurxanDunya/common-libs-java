package com.projecthope.news.repository.query;

public enum Queries {

    CREATE_NEWS("createNews"),
    FIND_LAST_ADDED("lastAdded"),
    FIND_ALL_NEWS("findAllNews"),
    FIND_BY_ID("findById");

    private final String key;

    Queries(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}