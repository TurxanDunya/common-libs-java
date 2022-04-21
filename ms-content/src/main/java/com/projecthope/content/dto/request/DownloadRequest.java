package com.projecthope.content.dto.request;

import com.projecthope.content.error.validation.constraints.ErrorMessages;
import com.projecthope.content.model.ContentClientBucket;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DownloadRequest {

    @NotEmpty(message = ErrorMessages.INVALID_DOWNLOAD_KEY)
    private String presignedUrl;

    @NotEmpty(message = ErrorMessages.INVALID_FILE_NAME)
    private String fileName;

    @NotNull(message = ErrorMessages.INVALID_BUCKET)
    private ContentClientBucket contentClientBucket;

}