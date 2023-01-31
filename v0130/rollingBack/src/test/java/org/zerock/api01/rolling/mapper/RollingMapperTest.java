package org.zerock.api01.rolling.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.api01.rolling.dto.*;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class RollingMapperTest {

    @Autowired
    RollingMapper rollingMapper;

    @Test
    void getList() {
        /*
        ['title']
        ['target']
        ['title', 'target']
         */
//        RollingSearchType[] types = {RollingSearchType.TARGET};
//        RollingSearchType[] types = {RollingSearchType.TITLE};
        RollingSearchType[] types = {RollingSearchType.TARGET, RollingSearchType.TITLE};
        RollingPageRequestDTO rollingPageRequestDTO =
                new RollingPageRequestDTO(1, 10, "박현준", types);

        List<RollingDTO> list = rollingMapper.getList(rollingPageRequestDTO);
        System.out.println(list);
    }

    @Test
    void getRolling() {
        RollingDTO rolling = rollingMapper.getRolling(682L);

        System.out.println(rolling);
    }

    @Test
    void addRolling() {
        AddRollingRequest addRollingRequest = new AddRollingRequest("title", "target", "imgSrc", 1L);
        AddRollingDTO addRollingDTO = new AddRollingDTO(addRollingRequest);
        rollingMapper.addRolling(addRollingDTO);

        System.out.println(addRollingDTO);
    }

    @Test
    void modifyRolling() {
        Long rollingId = 682L;
//        ModifyRollingRequest modifyRollingRequest = ModifyRollingRequest.builder().title(getNew("title")).build();
//        ModifyRollingRequest modifyRollingRequest = ModifyRollingRequest.builder().target(getNew("title")).build();
        ModifyRollingRequest modifyRollingRequest = ModifyRollingRequest.builder().imgSrc(getNew("title")).build();

        ModifyRollingDTO modifyRollingDTO = new ModifyRollingDTO(rollingId, modifyRollingRequest);
        rollingMapper.modifyRolling(modifyRollingDTO);

        RollingDTO rolling = rollingMapper.getRolling(rollingId);
        System.out.println(rolling);
    }

    @Test
    void deleteRolling() {
        Long rollingId = 682L;
        rollingMapper.deleteRolling(rollingId);

        rollingMapper.getRolling(rollingId);
    }

    public String getNew(String name) {
        String time = LocalDateTime.now().toString();
        return name + time;
    }
}