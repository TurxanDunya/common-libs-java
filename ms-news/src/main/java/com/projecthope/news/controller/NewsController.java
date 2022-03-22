package com.projecthope.news.controller;

import com.projecthope.news.dto.request.CreateNewsRequestDto;
import com.projecthope.news.dto.request.NewsFilter;
import com.projecthope.news.dto.response.CreateNewsResponseDto;
import com.projecthope.news.dto.response.NewsDto;
import com.projecthope.news.dto.response.NewsResponseDto;
import com.projecthope.news.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public CreateNewsResponseDto create(@Valid @RequestBody CreateNewsRequestDto request) {
        return newsService.create(request);
    }

    @GetMapping("/{id}")
    public NewsDto findById(@PathVariable Long id) {
        return newsService.findById(id);
    }

    @GetMapping
    public NewsResponseDto findAll(NewsFilter filter) {
        return newsService.findAll(filter);
    }

}