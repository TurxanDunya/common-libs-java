package com.projecthope.content.service;

import com.projecthope.content.config.MinioClientFactory;
import com.projecthope.content.config.properties.MinioProperties;
import com.projecthope.content.dto.request.DownloadRequest;
import com.projecthope.content.dto.request.UploadRequest;
import com.projecthope.content.dto.response.UploadResponse;
import com.projecthope.content.model.ContentClientBucket;
import io.minio.GetObjectArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ContentService {

    @Value("${spring.minio.expiry-time}")
    private Integer expiryTime;

    private final MinioProperties minioProperties;

    public ContentService(MinioProperties minioProperties) {
        this.minioProperties = minioProperties;
    }

    public UploadResponse upload(MultipartFile file, UploadRequest request) {
        log.debug("Request for uploading content. Content client: {}, file name: {}",
                request.getContentClient(),
                request.getFileName());

        ContentClientBucket contentClient = request.getContentClient();
        MinioClient minioClient = MinioClientFactory.getMinioClient(contentClient);

        try (var fileData = file.getInputStream()) {
            long startTime = System.currentTimeMillis();

            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(minioProperties.getBucket())
                    .object(request.getFileName())
                    .stream(fileData, fileData.available(), -1)
                    .contentType(file.getContentType())
                    .build());

            String presignedObjectUrl = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .bucket(contentClient.getBucket())
                            .object(request.getFileName())
                            .expiry(expiryTime, TimeUnit.MILLISECONDS)
                            .build());

            log.debug("File uploaded successfully. Upload time: {}",
                    (System.currentTimeMillis() - startTime) / 1000);

            return new UploadResponse(request.getFileName(), presignedObjectUrl);
        } catch (Exception e) {
            log.error("Occured error when upload file");
//            throw ServiceException.of(
//                    ErrorCodes.FILE_UPLOAD_ERROR, "Error occurred when upload file");
            throw new RuntimeException("Occurred error when upload file");
        }
    }

    public ByteArrayResource download(DownloadRequest request) {
        GetObjectArgs objectArgs = GetObjectArgs.builder()
                .bucket(minioProperties.getBucket())
                .object(request.getPresignedUrl() + request.getFileName())
                .build();

        ContentClientBucket contentClient = request.getContentClientBucket();
        MinioClient minioClient = MinioClientFactory.getMinioClient(contentClient);

        byte[] bytes;
        try {
            bytes = minioClient.getObject(objectArgs).readAllBytes();
        } catch (Exception e) {
            throw new RuntimeException("Occurred error when upload file");
        }

        return new ByteArrayResource(bytes);
    }

}