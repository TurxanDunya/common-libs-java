package com.projecthope.news.dto.response;

import com.projecthope.news.domain.News;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsResponseDto {

    private Boolean hasNext;
    private List<News> objects;

}