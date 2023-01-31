package org.zerock.api01.rolling.mapper;

import org.zerock.api01.common.dto.PageRequestDTO;
import org.zerock.api01.rolling.dto.RollingDTO;
import org.zerock.api01.rolling.vo.RollingVO;

import java.util.List;

public interface RollingMapper {
    int getCount(PageRequestDTO pageRequestDTO);

    List<RollingDTO> getList(PageRequestDTO pageRequestDTO);

    RollingDTO getRolling(Long id);

    int addRolling(RollingDTO rollingDTO);

    int modifyRolling(RollingDTO rollingDTO);

    int deleteRolling(Long rollingId);
}
