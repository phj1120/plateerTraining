package org.plateer.backlms.rolling.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RollingReplyCountDTO {
    private Long id;
    private String title;
    private Long writerId;
    private String target;
    private String imgSrc;
    private Long replyCount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateDt;
}
