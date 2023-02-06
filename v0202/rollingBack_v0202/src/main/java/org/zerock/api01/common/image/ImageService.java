package org.zerock.api01.common.image;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.api01.common.image.dto.FileDTO;
import org.zerock.api01.common.image.dto.SaveImagesDto;
import org.zerock.api01.common.image.dto.SaveResult;
import org.zerock.api01.common.image.mapper.FileMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

    private final FileMapper fileMapper;

    @Value("${basePath}")
    private String basePath;

    public List<String> getImagePaths(Long id) {
        return fileMapper.getImagePaths(id);
    }

    public Resource readImage(String storedName) {
        String imagePath = basePath + "/" + storedName;
        FileSystemResource file = new FileSystemResource(imagePath);

        log.info("[Read] : {}", storedName);
        return file;
    }

    public SaveResult saveImages(SaveImagesDto saveImagesDto) {
        return saveImages(saveImagesDto.getFiles());
    }


    public SaveResult saveImages(List<MultipartFile> files) {
        SaveResult saveResult = new SaveResult();

        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            try {
                String savedPath = saveImage(file);

                saveResult.success(i, savedPath);
            } catch (IllegalArgumentException e) {
                saveResult.fail(i);
            }
        }

        return saveResult;
    }

    private String saveImage(MultipartFile file) {
        validImage(file);

        String storedName = generateStoredName(file);

        FileDTO fileDTO = new FileDTO(file, storedName);
        fileMapper.addFile(fileDTO);

        try {
            initFolder();
            writeImageWithThumbnail(file, storedName);
        } catch (IOException e) {
            throw new IllegalArgumentException("파일 저장 실패");
        }

        log.info("[Save] : {} -> {}", file.getOriginalFilename(), storedName);
        return storedName;
    }

    private void writeImageWithThumbnail(MultipartFile file, String storedName) throws IOException {
        String imagePath = basePath + "/" + storedName;

        FileSystemResource resource = new FileSystemResource(imagePath);
        resource.getOutputStream().write(file.getBytes());

        Thumbnails.of(new File(imagePath))
                .forceSize(160, 160)
                .toFile(new File(basePath + "/s_" + storedName));
    }

    private void initFolder() {
        File folder = new File(basePath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    private void validImage(MultipartFile file) {
        if (!isImage(file)) {
            throw new IllegalArgumentException("이미지 파일 아님");
        }
    }

    private boolean isImage(MultipartFile file) {
        String contentType = file.getContentType();

        return contentType != null && contentType.startsWith("image/");
    }

    private String generateStoredName(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String[] data = originalFilename.split("[.]");
        String extension = data[data.length - 1];
        String storedName = UUID.randomUUID() + "." + extension;

        return storedName;
    }

    public void setRollingId(Long id, List<String> names) {
        fileMapper.setRollingId(id, names);
    }
}
