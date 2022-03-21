package com.projecthope.news.dto.request;

import com.projecthope.news.dto.NewsType;
import com.projecthope.news.error.validation.constraints.ErrorMessages;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateNewsRequestDto {

    @NotEmpty(message = ErrorMessages.EMPTY_HEADER)
    private String header;

    @NotEmpty(message = ErrorMessages.EMPTY_BODY)
    private String body;

    @NotNull(message = ErrorMessages.EMPTY_BODY)
    private NewsType type;
    private MultipartFile picture;

}