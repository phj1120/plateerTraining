package org.zerock.api01.todo.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.api01.common.dto.PageRequestDTO;
import org.zerock.api01.todo.dto.TodoDTO;

import java.util.List;

@SpringBootTest
@Log4j2
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        List<TodoDTO> dtoList = todoMapper.list(pageRequestDTO);

    }
}
