package com.projecthope.news.mapper.qualifier;

import com.projecthope.news.dto.NewsType;
import org.springframework.stereotype.Component;

@Component
public class EnumMapper {

    public NewsType toNewsType(Integer type) {
        return NewsType.of(type);
    }

    public Integer toNewsTypeValue(NewsType newsType) {
        return newsType.getValue();
    }

}