package org.plateer.backlms.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.backlms.member.dto.MemberRegDTO;
import org.plateer.backlms.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
@Log4j2
public class MemberController {
    private final MemberService memberService;

    @PostMapping("register")
    public ResponseEntity register(@RequestBody MemberRegDTO memberRegDTO) {
        memberService.register(memberRegDTO);

        return ResponseEntity.ok("OK");
    }
}
