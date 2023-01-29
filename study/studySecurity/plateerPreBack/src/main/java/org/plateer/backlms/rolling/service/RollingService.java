package org.plateer.backlms.rolling.service;

import org.plateer.backlms.common.dto.PageRequestDTO;
import org.plateer.backlms.common.dto.PageResultDTO;
import org.plateer.backlms.member.entity.Member;
import org.plateer.backlms.rolling.domain.Rolling;
import org.plateer.backlms.rolling.dto.RollingDTO;
import org.plateer.backlms.rolling.dto.RollingReplyCountDTO;
import org.plateer.backlms.rolling.dto.RollingSearchDTO;

public interface RollingService {
    default RollingDTO entityToDTO(Rolling rolling) {
        return RollingDTO.builder()
                .id(rolling.getId())
                .title(rolling.getTitle())
                .writerId(rolling.getWriter().getId())
                .target(rolling.getTarget())
                .createDt(rolling.getCreateDt())
                .updateDt(rolling.getUpdateDt())
                .imgSrc(rolling.getImgSrc())
                .build();
    }

    default Rolling DTOToEntity(RollingDTO rollingDTO, Member member) {
        return Rolling.builder()
                .id(rollingDTO.getId())
                .title(rollingDTO.getTitle())
                .writer(member)
                .target(rollingDTO.getTarget())
                .createDt(rollingDTO.getCreateDt())
                .updateDt(rollingDTO.getUpdateDt())
                .imgSrc(rollingDTO.getImgSrc())
                .build();
    }

    // 롤링 페이퍼 검색 리스트 서비스
    PageResultDTO<RollingReplyCountDTO> getRollingList(PageRequestDTO pageRequestDTO, RollingSearchDTO rollingSearchDTO);

    // 롤링 페이퍼 조회
    RollingDTO getRolling(Long id);

    // 롤링 페이퍼 추가
    RollingDTO addRolling(RollingDTO rollingDTO);

    // 롤링 페이퍼 수정
    RollingDTO modifyRolling(RollingDTO modifyRollingDTO);

    // 롤링 페이퍼 삭제
    Long removeRolling(Long id);
}
