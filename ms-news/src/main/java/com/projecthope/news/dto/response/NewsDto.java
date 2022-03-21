package com.projecthope.news.dto.response;

import com.projecthope.news.dto.NewsType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsDto {

    private Long id;
    private String header;
    private String body;
    private NewsType type;
    private LocalDateTime lastModified;

}
