package org.plateer.backlms.rolling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.backlms.rolling.domain.Member;
import org.plateer.backlms.rolling.dto.MemberRegDTO;
import org.plateer.backlms.rolling.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
@RequiredArgsConstructor
@Log4j2
@Service
public class MemberServiceImpl implements MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    public void register(MemberRegDTO memberRegDTO) {
        Member member = Member.builder()
                .memberId(memberRegDTO.getMemberId())
                .memberName(memberRegDTO.getMemberName())
                .password(passwordEncoder.encode(memberRegDTO.getPassword()))
                .authRole("ROLE_USER")
                .createDt(LocalDate.now())
                .build();

        memberRepository.save(member);
    }
}
