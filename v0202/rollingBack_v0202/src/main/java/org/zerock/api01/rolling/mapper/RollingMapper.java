package org.zerock.api01.rolling.mapper;

import org.zerock.api01.rolling.dto.AddRollingDTO;
import org.zerock.api01.rolling.dto.ModifyRollingDTO;
import org.zerock.api01.rolling.dto.RollingDTO;
import org.zerock.api01.rolling.dto.RollingPageRequestDTO;

import java.util.List;

public interface RollingMapper {
    int getCount(RollingPageRequestDTO rollingPageRequestDTO);

    List<RollingDTO> getList(RollingPageRequestDTO rollingPageRequestDTO);

    RollingDTO getRolling(Long id);

    int addRolling(AddRollingDTO addRollingDTO);

    int modifyRolling(ModifyRollingDTO modifyRollingDTO);

    int deleteRolling(Long rollingId);
}
