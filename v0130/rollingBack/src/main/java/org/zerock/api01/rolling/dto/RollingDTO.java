package org.zerock.api01.rolling.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateDt;
}
