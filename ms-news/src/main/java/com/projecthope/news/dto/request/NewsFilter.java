package com.projecthope.news.dto.request;

import com.projecthope.news.dto.NewsType;
import com.projecthope.news.error.validation.constraints.ErrorMessages;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NewsFilter {

    @NotNull(message = ErrorMessages.INVALID_NEWS_TYPE)
    private NewsType type;
    private Integer offset;
    private Integer limit;

}