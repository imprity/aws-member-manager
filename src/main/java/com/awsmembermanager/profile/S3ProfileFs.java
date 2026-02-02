package com.awsmembermanager.profile;

import io.awspring.cloud.s3.S3Template;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "use-s3-for-profile", matchIfMissing = false, havingValue = "true")
public class S3ProfileFs implements ProfileFs {
    private static final Duration PRESIGNED_URL_EXPIRATION = Duration.ofDays(7);

    private final S3Template s3Template;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

    @Override
    public String upload(MultipartFile file) throws RuntimeException {
        try {
            String key = "profiles/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
            s3Template.upload(bucket, key, file.getInputStream());
            return key;
        } catch (IOException e) {
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }

    @Override
    public String getDownloadUrl(String key) {
        return s3Template
                .createSignedGetURL(bucket, key, PRESIGNED_URL_EXPIRATION)
                .toString();
    }
}
