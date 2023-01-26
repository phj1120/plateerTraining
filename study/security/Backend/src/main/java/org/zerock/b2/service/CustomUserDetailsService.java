package org.zerock.b2.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zerock.b2.config.Encoder;

@Log4j2
@Service
@RequiredArgsConstructor
@Setter
public class CustomUserDetailsService implements UserDetailsService {

    private final Encoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("[CustomUserDetailsService]: loadUserByUsername");

        UserDetails userDetails = User.builder()
                .username(username)
                .password(encoder.getPasswordEncoder().encode("1111"))
                .authorities("ROLE_USER", "ROLE_ADMIN")
                .build();
        return userDetails;
    }

}
