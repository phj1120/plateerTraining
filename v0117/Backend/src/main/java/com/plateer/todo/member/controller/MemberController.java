package com.plateer.todo.member.controller;

import com.plateer.todo.member.RefreshDTO;
import com.plateer.todo.member.dto.LoginDTO;
import com.plateer.todo.member.dto.SignUpDTO;
import com.plateer.todo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/signup")
    public SignUpDTO signUp(@RequestBody @Valid SignUpDTO dto) {
        SignUpDTO signUpDTO = memberService.signUp(dto);

        return signUpDTO;
    }

    @PostMapping("/api/login")
    public RefreshDTO login(@RequestBody @Valid LoginDTO dto) {
        RefreshDTO refreshDTO = memberService.login(dto);

        return refreshDTO;
    }

}
