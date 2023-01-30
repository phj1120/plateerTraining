package org.zerock.api01.rolling.vo;

import lombok.*;
import org.zerock.api01.rolling.dto.RollingDTO;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RollingVO {
    private Long rollingId;
    private String title;
    private String target;
    private String imgSrc;
    private Long writerMemberId;

    public RollingVO(RollingDTO rollingDTO) {
        this.rollingId = rollingDTO.getRollingId();
        this.title = rollingDTO.getTitle();
        this.target = rollingDTO.getTarget();
        this.imgSrc = rollingDTO.getImgSrc();
        this.writerMemberId = rollingDTO.getWriterMemberId();
    }
}