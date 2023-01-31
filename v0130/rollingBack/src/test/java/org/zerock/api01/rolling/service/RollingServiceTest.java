package org.zerock.api01.rolling.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.api01.common.dto.PageResultDTO;
import org.zerock.api01.rolling.dto.AddRollingDTO;
import org.zerock.api01.rolling.dto.RollingDTO;
import org.zerock.api01.rolling.dto.RollingPageRequestDTO;
import org.zerock.api01.rolling.dto.RollingSearchType;

import java.util.List;

@SpringBootTest
class RollingServiceTest {

    @Autowired
    RollingService rollingService;

    @Test
    void getListByNoneSearch() {
        long page = 1;
        long size = 10;
        RollingPageRequestDTO rollingPageRequestDTO = new RollingPageRequestDTO(1, 10);
        PageResultDTO<RollingDTO> pageResultDTO = rollingService.getList(rollingPageRequestDTO);

        Assertions.assertThat(pageResultDTO.getPage()).isEqualTo(page);
        Assertions.assertThat(pageResultDTO.getSize()).isEqualTo(size);
    }

    @Test
    void getListSearchByOneType() {
        String keyword = "박현준";
        RollingPageRequestDTO rollingPageRequestDTO = new RollingPageRequestDTO(keyword, new RollingSearchType[]{RollingSearchType.TITLE});
        PageResultDTO<RollingDTO> pageResultDTO = rollingService.getList(rollingPageRequestDTO);
        List<RollingDTO> rollingDTOList = pageResultDTO.getDtoList();
        for (RollingDTO rollingDTO : rollingDTOList) {
            Assertions.assertThat(rollingDTO.getTitle()).contains(keyword);
        }
    }

    @Test
    void getListSearchByTwoType() {
        String keyword = "박현준";
        RollingPageRequestDTO rollingPageRequestDTO = new RollingPageRequestDTO(keyword, new RollingSearchType[]{RollingSearchType.TITLE, RollingSearchType.TARGET});
        PageResultDTO<RollingDTO> pageResultDTO = rollingService.getList(rollingPageRequestDTO);
        List<RollingDTO> rollingDTOList = pageResultDTO.getDtoList();
        for (RollingDTO rollingDTO : rollingDTOList) {
            Assertions.assertThat(keyword).containsAnyOf(rollingDTO.getTitle(), rollingDTO.getTarget());
        }
    }

    @Test
    void getRolling() {
    }

    @Test
    void addRolling() {
//        rollingService.addRolling();

    }

    @Test
    void modifyRolling() {
    }

    @Test
    void deleteRolling() {
    }
}