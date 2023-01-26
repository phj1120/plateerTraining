package org.zerock.b2.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encoder {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public BCryptPasswordEncoder getPasswordEncoder() {
        return this.bCryptPasswordEncoder;
    }
}

