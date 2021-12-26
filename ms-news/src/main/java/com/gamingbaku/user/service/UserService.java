package com.gamingbaku.user.service;

import com.gamingbaku.user.domain.request.CreateNewsRequest;
import com.gamingbaku.user.dto.request.CreateNewsRequestDto;
import com.gamingbaku.user.dto.response.CreateNewsResponseDto;
import com.gamingbaku.user.mapper.NewsMapper;
import com.gamingbaku.user.repository.NewsRepository;
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
        var request = CreateNewsRequest.builder()
                .header(requestDto.getHeader())
                .body(requestDto.getBody())
                .build();

        var response = newsRepository.create(request);
        return newsMapper.toCreateNewsResponseDto(response);
    }

    public CreateNewsRequestDto findById(Long id) {
        log.debug("Printed");
        return newsRepository.findById(id);
    }

}