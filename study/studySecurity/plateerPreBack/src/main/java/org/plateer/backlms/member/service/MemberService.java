package org.plateer.backlms.member.service;

import org.plateer.backlms.member.dto.SignUpDTO;
import org.plateer.backlms.member.dto.SignUpResultDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MemberService {
    SignUpResultDTO signUp(SignUpDTO signUpDTO);
}
