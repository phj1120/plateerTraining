package org.plateer.backlms.rolling.service;

import org.plateer.backlms.common.dto.PageRequestDTO;
import org.plateer.backlms.common.dto.PageResultDTO;
import org.plateer.backlms.rolling.dto.RollingDTO;
import org.plateer.backlms.rolling.dto.RollingSearchDTO;

public interface RollingService {
    Long addPaper(RollingDTO rollingDTO);

    // 롤링페이퍼 검색 리스트 서비스
    PageResultDTO<RollingDTO> getRollingList(PageRequestDTO pageRequestDTO, RollingSearchDTO rollingSearchDTO);

    RollingDTO getRolling(Long id);
}
