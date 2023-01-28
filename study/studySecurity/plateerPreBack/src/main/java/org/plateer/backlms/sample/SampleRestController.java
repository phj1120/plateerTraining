package org.plateer.backlms.sample;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping()
@Log4j2
public class SampleRestController {

    @PreAuthorize("permitAll()")
    @GetMapping("/api/sample/ex1")
    public Map<String, String> ex1() {


        return Map.of("v1", "AAA", "v2", "BBB");
    }

    //    @PreAuthorize("hasRole('USER')")
    @GetMapping("/auth/api/sample/ex2")
    public Map<String, String> ex2() {


        return Map.of("k1", "AAA", "k2", "BBB");
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/auth/api/sample/ex3")
    public Map<String, String> ex3() {

        return Map.of("c1", "AAA", "b3", "BBB");
    }

}
