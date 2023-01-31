package org.zerock.api01.rolling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.api01.common.dto.PageResultDTO;
import org.zerock.api01.rolling.dto.AddRollingDTO;
import org.zerock.api01.rolling.dto.ModifyRollingDTO;
import org.zerock.api01.rolling.dto.RollingDTO;
import org.zerock.api01.rolling.dto.RollingPageRequestDTO;
import org.zerock.api01.rolling.mapper.RollingMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class RollingServiceImpl implements RollingService {
    private final RollingMapper rollingMapper;

    @Override
    public PageResultDTO<RollingDTO> getList(RollingPageRequestDTO rollingPageRequestDTO) {
        List<RollingDTO> dtoList = rollingMapper.getList(rollingPageRequestDTO);

        int total = rollingMapper.getCount(rollingPageRequestDTO);

        PageResultDTO<RollingDTO> pageResponseDTO = PageResultDTO.<RollingDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(rollingPageRequestDTO).build();

        return pageResponseDTO;
    }

    @Override
    public RollingDTO getRolling(Long id) {
        RollingDTO rollingDTO = rollingMapper.getRolling(id);
        if (rollingDTO == null) {
            throw new RuntimeException("조회 실패");
        }

        return rollingDTO;
    }

    @Override
    public void addRolling(AddRollingDTO addRollingDTO) {
        int count = rollingMapper.addRolling(addRollingDTO);

        if (count != 1) {
            throw new RuntimeException("추가 실패");
        }
    }

    @Override
    public void modifyRolling(ModifyRollingDTO modifyRollingDTO) {
        int count = rollingMapper.modifyRolling(modifyRollingDTO);

        if (count < 1) {
            throw new RuntimeException("수정 실패");
        }
    }

    @Override
    public void deleteRolling(Long rollingId) {
        int count = rollingMapper.deleteRolling(rollingId);
        if (count != 1) {
            throw new RuntimeException("삭제 실패");
        }
    }
}
