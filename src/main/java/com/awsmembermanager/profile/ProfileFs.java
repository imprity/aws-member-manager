package com.awsmembermanager.profile;

import com.awsmembermanager.Dto;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileFs {
    public String upload(MultipartFile file);

    public Dto.GetMemberProfile getDownloadUrl(String key);
}
