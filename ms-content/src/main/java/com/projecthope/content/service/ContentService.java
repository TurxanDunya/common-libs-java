package com.projecthope.content.service;

import com.projecthope.content.config.MinioClientFactory;
import com.projecthope.content.config.properties.MinioProperties;
import com.projecthope.content.dto.request.UploadRequest;
import com.projecthope.content.dto.response.UploadResponse;
import com.projecthope.content.model.ContentClientBucket;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ContentService {

    private final MinioProperties minioProperties;

    public ContentService(MinioProperties minioProperties) {
        this.minioProperties = minioProperties;
    }

    public UploadResponse upload(MultipartFile file, UploadRequest request) {
        log.debug("Request for uploading content. Content client: {}", request.getContentClient());

        ContentClientBucket contentClient = request.getContentClient();
        MinioClient minioClient = MinioClientFactory.getMinioClient(contentClient);

        try (var fileData = file.getInputStream()) {
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(minioProperties.getBucket())
                    .object(request.getFileName())
                    .stream(fileData, fileData.available(), -1)
                    .contentType(file.getContentType())
                    .build());

            return new UploadResponse(request.getFileName());
        } catch (Exception e) {
            log.error("Occured error when upload file");
//            throw ServiceException.of(
//                    ErrorCodes.FILE_UPLOAD_ERROR, "Occured error when upload file");
            throw new RuntimeException("Occured error when upload file");
        }
    }

}