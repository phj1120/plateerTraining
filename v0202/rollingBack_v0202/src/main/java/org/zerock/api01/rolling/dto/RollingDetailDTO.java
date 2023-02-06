package org.zerock.api01.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RollingDetailDTO {
    private Long id;
    private String title;
    private String target;
    private List<String> imgSrcs;
    private Long writer;
    private LocalDate createDt;
    private LocalDate updateDt;

    public RollingDetailDTO(RollingDTO rollingDTO, List<String> imgSrcs) {
        this.id = rollingDTO.getRollingId();
        this.title = rollingDTO.getTitle();
        this.target = rollingDTO.getTarget();
        this.writer = rollingDTO.getWriterMemberId();
        this.createDt = rollingDTO.getCreateDt();
        this.updateDt = rollingDTO.getUpdateDt();
        this.imgSrcs = imgSrcs;
    }
}
