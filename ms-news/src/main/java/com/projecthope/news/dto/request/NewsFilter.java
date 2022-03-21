package com.projecthope.news.dto.request;

import com.projecthope.news.dto.NewsType;
import lombok.Data;

@Data
public class NewsFilter {

    private NewsType type;
    private Integer offset;
    private Integer limit;

}