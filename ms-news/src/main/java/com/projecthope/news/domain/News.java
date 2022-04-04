package com.projecthope.news.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {

    private Long id;
    private String header;
    private String body;
    private Integer type;
    private LocalDateTime lastModified;
    private String pictureKey;

}