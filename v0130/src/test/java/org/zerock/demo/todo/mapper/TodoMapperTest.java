package org.zerock.demo.todo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.demo.todo.dto.TodoDTO;

import java.util.List;

@SpringBootTest
class TodoMapperTest {

    @Autowired
    private TodoMapper todoMapper;

    @Test
    public void getNow() {
        String now = todoMapper.getNow();
        System.out.println(now);
    }

    @Test
    public void getTodo() {
        TodoDTO todo = todoMapper.getTodo(1L);
        System.out.println(todo);
    }

    @Test
    public void getTodos() {
        List<TodoDTO> todos = todoMapper.getTodos();
        System.out.println(todos);
    }

    @Test
    public void getTodoUseResultMap() {
        TodoDTO todoUseResultMap = todoMapper.getTodoUseResultMap(1L);
        System.out.println(todoUseResultMap);
    }

}