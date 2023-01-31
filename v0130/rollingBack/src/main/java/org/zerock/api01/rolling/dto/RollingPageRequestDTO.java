package org.zerock.api01.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.api01.common.dto.PageRequestDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RollingPageRequestDTO extends PageRequestDTO {
    String keyword;
    RollingSearchType type;
}
