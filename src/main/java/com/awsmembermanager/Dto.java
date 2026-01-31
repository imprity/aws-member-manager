package com.awsmembermanager;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Dto {
    private Dto() {}

    public record AddMemeber(
            @NotBlank(message = "이름은 비어있으면 안됩니다") String name,
            @Min(value = 0, message = "나이는 0 이상이어야 합니다") @NotNull(message = "나이는 비어있으면 안됩니다") Integer age,
            @NotNull(message = "MBTI는 비어있으면 안됩니다") Mbti mbti) {}

    public record GetMember(Long id, String name, Integer age, Mbti mbti) {
        public static GetMember of(Member member) {
            return new GetMember(member.getMemberId(), member.getName(), member.getAge(), member.getMbti());
        }
    }
}
