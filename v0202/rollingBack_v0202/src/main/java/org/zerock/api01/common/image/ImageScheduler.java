package org.zerock.api01.common.image;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Component
@RequiredArgsConstructor
public class ImageScheduler {

    @Value("${basePath}")
    private String basePath;

    private final ImageService imageService;


    @Scheduled(cron = "44 44 4 * * *")
    public void deleteImages() {
        // DB 에 있는 이미지 목록 조회
        Set<String> allNames = imageService.getAllFileNames().stream().collect(Collectors.toSet());

        // 이미지 목록 조회
        String DATA_DIRECTORY = basePath;
        File dir = new File(DATA_DIRECTORY);
        String[] filenames = dir.list();

        // 둘이 비교해 없는 이미지 삭제
        for (String fileName : filenames) {
            if (fileName.startsWith("s_") || allNames.contains(fileName)) {
                continue;
            }

            log.info(fileName);
            File deleteFile = new File(basePath + "/" + fileName);
            deleteFile.delete();
            File deleteThumbnail = new File(basePath + "/s_" + fileName);
            deleteThumbnail.delete();
        }

    }
}
