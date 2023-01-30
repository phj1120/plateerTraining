package org.zerock.api01.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyRollingRequest {
    private String title;
    private String target;

    public RollingDTO convert(Long rollingId) {
        return RollingDTO.builder()
                .rollingId(rollingId)
                .title(this.title)
                .target(this.target)
                .build();
    }
}
