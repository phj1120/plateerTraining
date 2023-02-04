package org.zerock.api01.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRollingDTO {
    private Long id;
    private String title;
    private String target;
    private Long writer;
    private LocalDate createDt;
    private List<MultipartFile> images;
    private Integer thumbnailIndex; // 썸네일 인덱스

    public AddRollingDTO(AddRollingRequest request) {
        this.title = request.getTitle();
        this.target = request.getTarget();
        this.writer = request.getWriter();
        this.createDt = LocalDate.now();
        this.images = request.getImages();
        this.thumbnailIndex = request.getThumbnailIndex();
    }

    public RollingDTO convert(String thumbnailPath) {
        return RollingDTO.builder()
                .rollingId(this.id)
                .title(this.title)
                .writerMemberId(this.writer)
                .target(this.target)
                .imgSrc(thumbnailPath)
                .createDt(this.createDt)
                .build();
    }

    public RollingDTO convert() {
        return RollingDTO.builder()
                .rollingId(this.id)
                .title(this.title)
                .writerMemberId(this.writer)
                .target(this.target)
                .createDt(this.createDt)
                .build();
    }
}
