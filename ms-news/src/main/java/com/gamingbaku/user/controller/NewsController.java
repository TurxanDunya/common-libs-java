package com.gamingbaku.user.controller;

import com.gamingbaku.user.dto.request.CreateNewsRequestDto;
import com.gamingbaku.user.dto.response.CreateNewsResponseDto;
import com.gamingbaku.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/news")
@AllArgsConstructor
public class NewsController {

    private final UserService userService;

    @PostMapping
    public CreateNewsResponseDto create(@Valid @RequestBody CreateNewsRequestDto requestDto) {
        return userService.create(requestDto);
    }

    @GetMapping("/{id}")
    public CreateNewsRequestDto findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

}