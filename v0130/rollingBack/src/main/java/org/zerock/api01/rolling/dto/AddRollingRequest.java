package org.zerock.api01.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRollingRequest {
    private String title;
    private String targetName;

    public RollingDTO convert() {
        return RollingDTO.builder()
                .title(title)
                .target(targetName)
                .build();
    }
}
