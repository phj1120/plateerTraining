package org.plateer.backlms.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.backlms.member.entity.Member;
import org.plateer.backlms.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("UserDetails.......................");
        Member member = memberRepository.findByMemberId(username)
                .orElseThrow(() -> new RuntimeException("존재 하지 않는 사용자"));

        UserDetails userDetails = User.builder()
                .username(username)
                .password(member.getPassword())
                .authorities(member.getAuthRole())
                .build();

        return userDetails;
    }
}
