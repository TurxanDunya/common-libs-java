package com.projecthope.news.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsResponseDto {

    private Boolean hasNext;
    private List<NewsDto> objects;

}