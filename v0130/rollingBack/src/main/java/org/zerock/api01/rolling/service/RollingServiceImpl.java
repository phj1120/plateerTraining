package org.zerock.api01.rolling.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.api01.common.dto.PageRequestDTO;
import org.zerock.api01.common.dto.PageResultDTO;
import org.zerock.api01.rolling.dto.RollingDTO;
import org.zerock.api01.rolling.mapper.RollingMapper;
import org.zerock.api01.rolling.vo.RollingVO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class RollingServiceImpl implements RollingService {
    private final RollingMapper rollingMapper;

    @Override
    public PageResultDTO<RollingVO> getList(PageRequestDTO pageRequestDTO) {
        List<RollingVO> volist = rollingMapper.getList(pageRequestDTO);
        int total = rollingMapper.getCount(pageRequestDTO);

        PageResultDTO<RollingVO> pageResponseDTO = PageResultDTO.<RollingVO>withAll()
                .dtoList(volist)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Override
    public RollingVO getRolling(Long id) {
        RollingVO rollingVO = rollingMapper.getRolling(id);

        return rollingVO;
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
