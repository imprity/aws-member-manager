package com.awsmembermanager;

import com.awsmembermanager.CustomExceptions.MemberHasNoProfileException;
import com.awsmembermanager.CustomExceptions.MemberNotFoundException;
import com.awsmembermanager.profile.ProfileFs;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberService {
    private final MemberRepo memberRepo;
    private final ProfileFs profileFs;

    @Transactional
    public Dto.GetMember addMember(Dto.AddMemeber req) {
        Member member = new Member(req.name(), req.age(), req.mbti());

        memberRepo.save(member);

        return Dto.GetMember.of(member);
    }

    @Transactional(readOnly = true)
    public Dto.GetMember getMember(Long memberId) {
        Member member = memberRepo.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));

        return Dto.GetMember.of(member);
    }

    @Transactional()
    public Dto.GetMember addMemberProfile(Long memberId, MultipartFile file) {
        Member member = memberRepo.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));

        String key = profileFs.upload(file);

        member.setProfileKey(key);

        return Dto.GetMember.of(member);
    }

    @Transactional(readOnly = true)
    public Dto.GetMemberProfile getMemberProfile(Long memberId) {
        Member member = memberRepo.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));

        String key = member.getProfileKey();

        if (key == null) {
            throw new MemberHasNoProfileException(memberId);
        }

        return profileFs.getDownloadUrl(key);
    }
}
