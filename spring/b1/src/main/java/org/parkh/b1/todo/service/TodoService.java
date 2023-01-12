package org.parkh.b1.todo.service;

import org.parkh.b1.todo.dto.TodoListDto;

import java.util.List;

public interface TodoService {
    List<TodoListDto> getList();
}
