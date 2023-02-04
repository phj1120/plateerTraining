package org.zerock.api01.rolling.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.api01.rolling.vo.RollingVO;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RollingDTO {
    private Long rollingId;
    private String title;
    private Long writerMemberId;
    private String target;
    private String imgSrc;
    private LocalDate createDt;
    private LocalDate updateDt;

    public RollingDTO(RollingVO rollingVO) {
        this.rollingId = rollingVO.getRollingId();
        this.title = rollingVO.getTitle();
        this.target = rollingVO.getTarget();
        this.imgSrc = rollingVO.getImgSrc();
        this.writerMemberId = rollingVO.getWriterMemberId();
        this.createDt = rollingVO.getCreatDt();
        this.updateDt = rollingVO.getUpdateDt();
    }
}
