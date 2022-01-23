package com.projecthope.news.mapper;

import com.projecthope.news.domain.News;
import com.projecthope.news.dto.request.CreateNewsRequestDto;
import com.projecthope.news.dto.response.NewsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    News toNews(CreateNewsRequestDto requestDto);

    NewsDto toNewsDto(News news);

}