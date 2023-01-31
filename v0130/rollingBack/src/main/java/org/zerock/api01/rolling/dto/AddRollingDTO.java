package org.zerock.api01.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRollingDTO {
    private Long id;
    private String title;
    private String target;
    private String imgSrc;
    private Long writer;
    private LocalDate createDt;

    public AddRollingDTO(AddRollingRequest request) {
        this.title = request.getTitle();
        this.target = request.getTarget();
        this.imgSrc = request.getImgSrc();
        this.writer = request.getWriter();
        this.createDt = LocalDate.now();
    }

    public AddRollingDTO(String title, String target, String imgSrc, Long writer, LocalDate createDt) {
        this.title = title;
        this.target = target;
        this.imgSrc = imgSrc;
        this.writer = writer;
        this.createDt = createDt;
    }
}
