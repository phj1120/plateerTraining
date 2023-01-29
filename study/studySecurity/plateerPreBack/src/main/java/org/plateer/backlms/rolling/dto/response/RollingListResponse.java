package org.plateer.backlms.rolling.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RollingListResponse {
    private Long id;
    private String title;
    private String writer;
    private String target;
    private String imgSrc;
    private Long replyCount;
}
