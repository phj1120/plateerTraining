package org.zerock.api01.rolling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.api01.common.dto.PageRequestDTO;
import org.zerock.api01.common.dto.PageResultDTO;
import org.zerock.api01.rolling.dto.RollingDTO;
import org.zerock.api01.rolling.mapper.RollingMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class RollingServiceImpl implements RollingService {
    private final RollingMapper rollingMapper;

    @Override
    public PageResultDTO<RollingDTO> getList(PageRequestDTO pageRequestDTO) {
        List<RollingDTO> volist = rollingMapper.getList(pageRequestDTO);
        int total = rollingMapper.getCount(pageRequestDTO);

        PageResultDTO<RollingDTO> pageResponseDTO = PageResultDTO.<RollingDTO>withAll()
                .dtoList(volist)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Override
    public RollingDTO getRolling(Long id) {
        RollingDTO rollingDTO = rollingMapper.getRolling(id);

        return rollingDTO;
    }

    @Override
    public void addRolling(RollingDTO rollingDTO) {
        int count = rollingMapper.addRolling(rollingDTO);
        if (count != 1) {
            throw new RuntimeException();
        }
    }

    @Override
    public void modifyRolling(RollingDTO rollingDTO) {
        int count = rollingMapper.modifyRolling(rollingDTO);
        if (count < 1) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteRolling(Long rollingId) {
        int count = rollingMapper.deleteRolling(rollingId);
        if (count != 1) {
            throw new RuntimeException();
        }
    }
}
