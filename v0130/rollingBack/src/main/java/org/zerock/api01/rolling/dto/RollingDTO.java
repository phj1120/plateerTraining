package org.zerock.api01.rolling.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    private Long rollingId;
    private String title;
    @JsonProperty("writer")
    private Long writerMemberId;
    private String target;
    private String imgSrc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDt;

    public RollingDTO(RollingVO rollingVO) {
        this.rollingId = rollingVO.getRollingId();
        this.title = rollingVO.getTitle();
        this.target = rollingVO.getTarget();
        this.imgSrc = rollingVO.getImgSrc();
        this.writerMemberId = rollingVO.getWriterMemberId();
        this.createDt = rollingVO.getCreatDt();
    }
}
