package org.plateer.backlms.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.backlms.member.dto.MemberDTO;
import org.plateer.backlms.member.dto.SignUpDTO;
import org.plateer.backlms.member.dto.SignUpResultDTO;
import org.plateer.backlms.member.entity.Member;
import org.plateer.backlms.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberDTO signUp(SignUpDTO signUpDTO) {
        String memberId = signUpDTO.getMemberId();
        String password = passwordEncoder.encode(signUpDTO.getPassword());
        String memberName = signUpDTO.getMemberName();

        Member member = new Member(memberId, password, memberName);
        Member saveMember = memberRepository.save(member);

        MemberDTO memberDTO = new MemberDTO(saveMember);

        return memberDTO;
    }

//    public SignUpResultDTO signUp(SignUpDTO signUpDTO) {
//        String memberId = signUpDTO.getMemberId();
//        String password = passwordEncoder.encode(signUpDTO.getPassword());
//        String memberName = signUpDTO.getMemberName();
//
//        Member member = new Member(memberId, password, memberName);
//        Member saveMember = memberRepository.save(member);
//
//        SignUpResultDTO signUpResultDTO = new SignUpResultDTO(saveMember);
//
//        return signUpResultDTO;
//    }


}
