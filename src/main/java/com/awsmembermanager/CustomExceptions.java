package com.awsmembermanager;

public class CustomExceptions {
    private CustomExceptions() {}

    public static class MemberNotFoundException extends RuntimeException {
        public MemberNotFoundException(Long memberId) {
            super(String.format("%s id의 Member를 찾지 못했습니다", memberId));
        }
    }

    public static class MemberHasNoProfileException extends RuntimeException {
        public MemberHasNoProfileException(Long memberId) {
            super(String.format("%s id의 Member는 프로파일 사진이 없습니다", memberId));
        }
    }

    public static class ProfileUploadException extends RuntimeException {
        public ProfileUploadException(Throwable cause) {
            super("프로필 업로드를 실패했습니다", cause);
        }
    }

    public static class ProfileDownloadUrlException extends RuntimeException {
        public ProfileDownloadUrlException(Throwable cause) {
            super("프로필 다운로드 URL을 받아오는데 실패했습니다", cause);
        }
    }
}
