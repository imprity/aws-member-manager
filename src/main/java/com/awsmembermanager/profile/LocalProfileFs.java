package com.awsmembermanager.profile;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

// TODO: 현재는 실제 저장한 사진을 사용자가 다운로드 할 수 없습니다.
// 물로 테스트 용으로 만든 거긴 하지만, 나중에 실제로 사용자가 다운로드 할 수 있으면 좋은 거 같습니다.
// (... 구현할 시간이 있다면요...)

@Component
@ConditionalOnProperty(name = "use-s3-for-profile", matchIfMissing = true, havingValue = "false")
@Slf4j
public class LocalProfileFs implements ProfileFs {
    private Path profileDir = null;

    private final String PROFILES_PATH = "./profiles";

    @PostConstruct
    public void init() throws IOException {
        log.info("creating profile directory at : {}", PROFILES_PATH);
        profileDir = Files.createDirectories(Path.of(PROFILES_PATH));
    }

    @Override
    public String upload(MultipartFile file) throws RuntimeException {
        try {
            Path filePath = Path.of(UUID.randomUUID() + "_" + file.getOriginalFilename());
            Path profileUri = Paths.get(profileDir.toString(), filePath.toString());
            Files.write(profileUri, file.getBytes());

            return profileUri.toUri().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDownloadUrl(String key) {
        return key;
    }
}
