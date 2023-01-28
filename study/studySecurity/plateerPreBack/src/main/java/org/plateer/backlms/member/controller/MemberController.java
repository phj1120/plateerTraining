package org.plateer.backlms.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.plateer.backlms.common.dto.ResultDTO;
import org.plateer.backlms.member.dto.SignUpDTO;
import org.plateer.backlms.member.dto.request.SignUpRequest;
import org.plateer.backlms.member.dto.response.SignUpResponse;
import org.plateer.backlms.member.dto.SignUpResultDTO;
import org.plateer.backlms.member.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
@Log4j2
public class MemberController {
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    @PostMapping("sign-up")
    public ResultDTO<SignUpResponse> signUp(@RequestBody SignUpRequest request) {
        SignUpDTO signUpDTO = modelMapper.map(request, SignUpDTO.class);
        SignUpResultDTO signUpResultDTO = memberService.signUp(signUpDTO);
        SignUpResponse signUpResponse = modelMapper.map(signUpResultDTO, SignUpResponse.class);

        return new ResultDTO<>(signUpResponse);
    }
}
