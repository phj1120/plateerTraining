package org.zerock.api01.rolling.service;

import org.zerock.api01.common.dto.PageRequestDTO;
import org.zerock.api01.common.dto.PageResultDTO;
import org.zerock.api01.rolling.dto.RollingDTO;

public interface RollingService {
    PageResultDTO<RollingDTO> getList(PageRequestDTO pageRequestDTO);

    RollingDTO getRolling(Long id);

    void addRolling(RollingDTO rollingDTO);

    void modifyRolling(RollingDTO rollingDTO);

    void deleteRolling(Long id);
}
