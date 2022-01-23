package com.projecthope.news.dto;

import java.util.stream.Stream;

public enum NewsType {

    GAME(1),
    FILM(2),
    TECHNO(3),
    OTHER(4),
    ALL(5);

    private final int value;

    NewsType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static NewsType of(int value) {
        return Stream.of(NewsType.values())
                .filter(newsType -> newsType.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}