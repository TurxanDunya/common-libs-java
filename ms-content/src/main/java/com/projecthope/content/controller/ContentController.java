package com.projecthope.content.controller;

import com.projecthope.content.dto.request.UploadRequest;
import com.projecthope.content.dto.response.UploadResponse;
import com.projecthope.content.service.ContentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/upload")
    public UploadResponse upload(@RequestPart("file") MultipartFile file,
                                 @Valid @RequestPart("request") UploadRequest request) {
        return contentService.upload(file, request);
    }

    @PostMapping("/download")
    public void download() {

    }

}