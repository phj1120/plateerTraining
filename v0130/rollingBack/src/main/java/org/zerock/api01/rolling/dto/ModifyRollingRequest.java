package org.zerock.api01.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModifyRollingRequest {
    private String title;
    private String target;
    private String imgSrc;
}
