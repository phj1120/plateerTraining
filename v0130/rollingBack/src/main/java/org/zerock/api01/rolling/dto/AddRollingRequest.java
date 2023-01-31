package org.zerock.api01.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRollingRequest {
    private String title;
    private String target;
    private String imgSrc;
    private Long writer;
}
