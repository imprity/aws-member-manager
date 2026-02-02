package com.awsmembermanager;

public class CustomExceptions {
    private CustomExceptions() {}
    ;

    public static class MemberNotFoundException extends RuntimeException {
        public MemberNotFoundException(Long memberId) {
            super(String.format("%s id의 Member를 찾지 못했습니다", memberId));
        }
    }
}
