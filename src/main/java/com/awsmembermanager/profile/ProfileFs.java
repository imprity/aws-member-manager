package com.awsmembermanager.profile;

import org.springframework.web.multipart.MultipartFile;

public interface ProfileFs {
    public String upload(MultipartFile file);

    public String getDownloadUrl(String key);
}
