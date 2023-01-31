package org.zerock.api01.rolling.service;

import org.zerock.api01.common.dto.PageResultDTO;
import org.zerock.api01.rolling.dto.AddRollingDTO;
import org.zerock.api01.rolling.dto.ModifyRollingDTO;
import org.zerock.api01.rolling.dto.RollingDTO;
import org.zerock.api01.rolling.dto.RollingPageRequestDTO;

public interface RollingService {
    PageResultDTO<RollingDTO> getList(RollingPageRequestDTO rollingPageRequestDTO);

    RollingDTO getRolling(Long id);

    void addRolling(AddRollingDTO addRollingDTO);

    void modifyRolling(ModifyRollingDTO modifyRollingDTO);

    void deleteRolling(Long id);
}
