package org.plateer.backlms.rolling.repository.search;

import org.plateer.backlms.rolling.dto.RollingReplyCountDTO;
import org.plateer.backlms.rolling.dto.RollingSearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RollingSearch {
    Page<RollingReplyCountDTO> searchList(Pageable pageable, RollingSearchDTO rollingSearchDTO);
}
