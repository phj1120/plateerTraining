package org.zerock.api01.rolling.service;

import org.zerock.api01.common.dto.PageRequestDTO;
import org.zerock.api01.common.dto.PageResultDTO;
import org.zerock.api01.rolling.dto.RollingDTO;
import org.zerock.api01.rolling.dto.RollingPageRequestDTO;

public interface RollingService {
    PageResultDTO<RollingDTO> getList(RollingPageRequestDTO rollingPageRequestDTO);

    RollingDTO getRolling(Long id);

    void addRolling(RollingDTO rollingDTO);

    void modifyRolling(RollingDTO rollingDTO);

    void deleteRolling(Long id);
}
