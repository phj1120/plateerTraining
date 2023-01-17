package com.plateer.todo.member.service;

import com.plateer.todo.common.util.JWTUtil;
import com.plateer.todo.member.RefreshDTO;
import com.plateer.todo.member.dto.LoginDTO;
import com.plateer.todo.member.dto.SignUpDTO;
import com.plateer.todo.member.entity.Member;
import com.plateer.todo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final JWTUtil jwtUtil;

    public RefreshDTO login(LoginDTO dto) {
        Member existMember = memberRepository.findByUsername(dto.getUsername()).orElseThrow(() -> {
            throw new RuntimeException();
        });

        if (!dto.getPassword().equals(existMember.getPassword())) {
            throw new RuntimeException();
        }
        Map claims = Map.of("mid", dto.getUsername());

        return new RefreshDTO(jwtUtil.generateToken(claims, 1),
                jwtUtil.generateToken(claims, 10));
    }

    public SignUpDTO signUp(SignUpDTO dto) {
        Member member = modelMapper.map(dto, Member.class);
        Member saveMember = memberRepository.save(member);

        return modelMapper.map(saveMember, SignUpDTO.class);
    }
}
