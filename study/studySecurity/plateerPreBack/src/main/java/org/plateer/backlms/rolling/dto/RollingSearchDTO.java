package org.plateer.backlms.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RollingSearchDTO {
    private RollingSearchType searchType;
    private String searchValue;
}
