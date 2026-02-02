package com.awsmembermanager;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/api/members")
    public ResponseEntity<Dto.GetMember> addMember(@Valid @RequestBody Dto.AddMember req) {
        Dto.GetMember res = memberService.addMember(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/api/members/{memberId}")
    public ResponseEntity<Dto.GetMember> getMember(@PathVariable Long memberId) {
        Dto.GetMember res = memberService.getMember(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/api/members/{memberId}/profile-image")
    public ResponseEntity<Dto.GetMember> addMemberProfile(
            @PathVariable Long memberId, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.addMemberProfile(memberId, file));
    }

    @GetMapping("/api/members/{memberId}/profile-image")
    public ResponseEntity<Dto.GetMemberProfile> getMemberProfile(@PathVariable Long memberId) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getMemberProfile(memberId));
    }
}
