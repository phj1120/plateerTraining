package com.plateer.todo.util;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.plateer.todo.common.util.JWTUtil;

import java.util.Map;

@SpringBootTest
@Log4j2
public class JWTTests {

    @Autowired
    JWTUtil jwtUtil;

    @Test
    public void testGenerate() {

        Map<String, Object> map = Map.of("mid","user00");

        String jwtStr = jwtUtil.generateToken(map, 10);

        log.info(jwtStr);

    }

    @Test
    public void testValid() {

        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzM5MjE3NTUsIm1pZCI6InVzZXIwMCIsImlhdCI6MTY3MzkyMTE1NX0.s1_alVAc-c32C8o390vibslpo8onABWTRkvHmzg36AE
        String jwt ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzM5MjE3NTUsIm1pZCI6InVzZXIwMCIsImlhdCI6MTY3MzkyMTE1NX0.s1_alVAc-c32C8o390vibslpo8onABWTRkvHmzg36AE";

        try {
            log.info(jwtUtil.validateToken(jwt));
        }catch(io.jsonwebtoken.SignatureException e){
            log.error("SignatureException");
        }catch(io.jsonwebtoken.ExpiredJwtException ee){
            log.error("ExpiredJwtException");
        }

    }

}
