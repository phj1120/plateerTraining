package org.zerock.api01.rolling.vo;

import lombok.*;

import java.time.LocalDate;

// 테이블과 1대 1 매칭
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
    private LocalDate creatDt;
    private LocalDate updateDt;
}