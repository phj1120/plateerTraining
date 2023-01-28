package org.plateer.backlms.rolling.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.backlms.rolling.dto.MemberRegDTO;
import org.plateer.backlms.rolling.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
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
