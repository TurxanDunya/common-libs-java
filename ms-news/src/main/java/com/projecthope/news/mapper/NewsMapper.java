package com.projecthope.news.mapper;

import com.projecthope.news.domain.News;
import com.projecthope.news.dto.request.CreateNewsRequestDto;
import com.projecthope.news.dto.response.NewsDto;
import com.projecthope.news.mapper.qualifier.EnumMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring",
        imports = LocalDateTime.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = EnumMapper.class)
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    @Mapping(target = "lastModified", expression = "java(LocalDateTime.now())")
    News toNews(CreateNewsRequestDto requestDto);

    NewsDto toNewsDto(News news);

    List<NewsDto> toNewsDtoList(List<News> news);

}