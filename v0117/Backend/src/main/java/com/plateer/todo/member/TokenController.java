package com.plateer.todo.member;

import com.plateer.todo.common.util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TokenController {

    private final JWTUtil jwtUtil;

    @PostMapping("/api/generate")
    public Map<String, String> generate() {

        Map claims = Map.of("mid", "user00");

        return Map.of("access", jwtUtil.generateToken(claims, 2),
                "refresh", jwtUtil.generateToken(claims, 10)
        );
    }

    @PostMapping("/api/refresh")
    public ResponseEntity<Map<String, String>> refresh(@RequestBody RefreshDTO refreshDTO) {
        log.info("[refresh]");
        String access = refreshDTO.getAccess();
        String refresh = refreshDTO.getRefresh();

        //access 만료된 것인지
        //refresh는 아직 유효한지
        try {
            jwtUtil.validateToken(refresh);

            Map claims = Map.of("mid", "user00");
            Map<String, String> result = Map.of("access", jwtUtil.generateToken(claims, 2),
                    "refresh", jwtUtil.generateToken(claims, 10)
            );

            return ResponseEntity.ok(result);
        } catch (ExpiredJwtException exp) {
            log.info("[refresh]: ExpiredJwtException");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of("MSG", "PLZLOGIN"));
        }
    }

}
