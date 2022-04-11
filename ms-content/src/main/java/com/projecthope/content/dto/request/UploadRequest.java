package com.projecthope.content.dto.request;

import com.projecthope.content.model.ContentClientBucket;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UploadRequest {

    @NotNull
    private ContentClientBucket contentClient;

    @NotEmpty
    private String fileName;

}
