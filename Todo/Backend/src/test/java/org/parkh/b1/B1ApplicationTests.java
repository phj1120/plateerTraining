package org.parkh.b1;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class B1ApplicationTests {

    @Test
    void contextLoads() {
        log.info("---------");
        String s1 = "AAA";
        String s2 = "AAA";

        System.out.println(s1 == s2);

    }

}
