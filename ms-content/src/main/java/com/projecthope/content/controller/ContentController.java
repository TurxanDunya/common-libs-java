package com.projecthope.content.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentController {

    @PostMapping
    public void upload() {

    }

    @PostMapping
    public void download() {

    }

}