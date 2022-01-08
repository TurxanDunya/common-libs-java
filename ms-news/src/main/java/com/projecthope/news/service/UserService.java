package com.projecthope.news.service;

import com.projecthope.news.domain.News;
import com.projecthope.news.dto.request.CreateNewsRequestDto;
import com.projecthope.news.dto.response.CreateNewsResponseDto;
import com.projecthope.news.mapper.NewsMapper;
import com.projecthope.news.repository.NewsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public UserService(NewsRepository newsRepository,
                       NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    public CreateNewsResponseDto create(CreateNewsRequestDto requestDto) {
        var request = News.builder()
                .header(requestDto.getHeader())
                .body(requestDto.getBody())
                .build();

        var response = newsRepository.save(request);
        return new CreateNewsResponseDto(response.getId());
    }

    public CreateNewsRequestDto findById(Long id) {
//        return newsRepository.getById(id);
        return null;
    }

}