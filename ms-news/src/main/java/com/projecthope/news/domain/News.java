package com.projecthope.news.domain;

import com.projecthope.news.dto.NewsType;
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
    private String pictureKey;
    private NewsType type;
    private LocalDateTime lastModified;

}