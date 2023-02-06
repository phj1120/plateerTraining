package org.zerock.api01.common.image;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImageSchedulerTest {

    @Autowired
    ImageScheduler imageScheduler;

    @Test
    public void deleteImages() {
        imageScheduler.deleteImages();
    }

}