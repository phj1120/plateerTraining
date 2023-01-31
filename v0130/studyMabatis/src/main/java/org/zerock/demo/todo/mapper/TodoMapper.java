package org.zerock.demo.todo.mapper;

import org.zerock.demo.todo.dto.TodoDTO;

import java.util.List;

public interface TodoMapper {
    String getNow();

    TodoDTO getTodo(Long id);

    List<TodoDTO> getTodos();


    TodoDTO getTodoUseResultMap(Long id);
}
