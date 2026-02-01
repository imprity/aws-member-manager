package com.awsmembermanager;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/api/members")
    public ResponseEntity addMember(@Valid @RequestBody Dto.AddMemeber req) {
        Dto.GetMember res = memberService.addMember(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/api/members/{memberId}")
    public ResponseEntity getMember(@PathVariable Long memberId) {
        Dto.GetMember res = memberService.getMember(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
