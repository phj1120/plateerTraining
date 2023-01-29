package org.plateer.backlms.rolling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.backlms.common.dto.PageRequestDTO;
import org.plateer.backlms.common.dto.PageResultDTO;
import org.plateer.backlms.member.entity.Member;
import org.plateer.backlms.rolling.domain.Rolling;
import org.plateer.backlms.rolling.dto.RollingDTO;
import org.plateer.backlms.rolling.dto.RollingReplyCountDTO;
import org.plateer.backlms.rolling.dto.RollingSearchDTO;
import org.plateer.backlms.rolling.repository.RollingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class RollingServiceImpl implements RollingService {
    private final RollingRepository rollingRepository;

    @Override
    public RollingDTO addRolling(RollingDTO rollingDTO) {
        Member member = Member.builder().id(rollingDTO.getWriterId()).build();
        Rolling rolling = DTOToEntity(rollingDTO, member);
        rollingRepository.save(rolling);
        RollingDTO saveRollingDTO = entityToDTO(rolling);

        return saveRollingDTO;
    }

    @Override
    public RollingDTO modifyRolling(RollingDTO modifyRollingDTO) {
        return null;
    }

    @Override
    public Long removeRolling(Long id) {
        return null;
    }

    @Override
    public PageResultDTO<RollingReplyCountDTO> getRollingList(PageRequestDTO pageRequestDTO, RollingSearchDTO rollingSearchDTO) {
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("id").descending());

        Page<RollingReplyCountDTO> rollingDTOPage = rollingRepository.searchList(pageable, rollingSearchDTO);

        PageResultDTO<RollingReplyCountDTO> pageResultDTO = new PageResultDTO<>(rollingDTOPage, pageable);

        return pageResultDTO;
    }

    @Override
    public RollingDTO getRolling(Long id) {
        return null;
    }
}
