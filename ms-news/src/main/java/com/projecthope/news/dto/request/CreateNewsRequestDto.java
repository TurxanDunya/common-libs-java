package com.projecthope.news.dto.request;

import com.projecthope.news.error.validation.constraints.ErrorMessage;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateNewsRequestDto {

    @NotEmpty(message = ErrorMessage.EMPTY_HEADER)
    private String header;

    @NotEmpty(message = ErrorMessage.EMPTY_BODY)
    private String body;
    private MultipartFile picture;

}