package org.zerock.api01.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRollingRequest {
    private String title;
    private String target;
    private String imgSrc;
    private Long writer;
}
