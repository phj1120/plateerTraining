package org.zerock.api01.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModifyRollingDTO {
    private Long id;
    private String title;
    private String target;
    private String imgSrc;
    private LocalDate updateDt;

    public ModifyRollingDTO(Long id, ModifyRollingRequest modifyRollingRequest) {
        this.id = id;
        this.title = modifyRollingRequest.getTitle();
        this.target = modifyRollingRequest.getTarget();
        this.imgSrc = modifyRollingRequest.getImgSrc();
        this.updateDt = LocalDate.now();
    }
}
