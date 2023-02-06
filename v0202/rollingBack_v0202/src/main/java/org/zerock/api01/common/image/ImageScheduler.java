package org.zerock.api01.common.image;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Set;

@Log4j2
@Component
@RequiredArgsConstructor
public class ImageScheduler {

    @Value("${basePath}")
    private String basePath;

    private final ImageService imageService;

    @Scheduled(cron = "0 0 4 * * *")
    public void deleteImages() {
        // DB 에 있는 이미지 목록 조회
        Set<String> allNames = imageService.getAllFileNames();

        // 이미지 목록 조회
        File dir = new File(basePath);
        String[] filenames = dir.list();

        // 둘이 비교해 없는 이미지 삭제
        for (String fileName : filenames) {
            if (fileName.startsWith("s_") || allNames.contains(fileName)) {
                continue;
            }
            deleteFile(basePath + "/" + fileName);
            deleteFile(basePath + "/s_" + fileName);
        }
    }

    private void deleteFile(String fileName) {
        try {
            File deleteFile = new File(basePath + "/" + fileName);
            deleteFile.delete();
        } catch (NullPointerException npe) {
            log.info("[존재하지 않는 파일]: " + fileName);
        }
    }
}
