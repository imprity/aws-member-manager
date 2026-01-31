package com.awsmembermanager;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberService {
    private final MemberRepo memberRepo;

    @Transactional
    public Dto.GetMember addMember(Dto.AddMemeber req) {
        Member member = new Member(req.name(), req.age(), req.mbti());

        memberRepo.save(member);

        return Dto.GetMember.of(member);
    }

    @Transactional(readOnly = true)
    public Dto.GetMember getMember(Long memberId) {
        Member member = memberRepo
                .findById(memberId)
                .orElseThrow(() -> new RuntimeException(String.format("%s id의 Member를 찾지 못했습니다", memberId)));

        return Dto.GetMember.of(member);
    }
}
