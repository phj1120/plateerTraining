package org.parkh.b1.todo.service;

import org.parkh.b1.common.domain.dto.PageResultDTO;
import org.parkh.b1.todo.domain.Todo;
import org.parkh.b1.todo.dto.SearchConditionDto;
import org.parkh.b1.todo.dto.TodoAddDTO;
import org.parkh.b1.todo.dto.TodoDto;
import org.parkh.b1.todo.dto.TodoListDTO;

public interface TodoService {

    TodoDto add(TodoAddDTO dto);

    PageResultDTO<TodoListDTO> getList();
    PageResultDTO<TodoListDTO> getList(SearchConditionDto dto);

    default Todo getEntity(TodoDto dto) {
        return Todo.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .writer(dto.getWriter())
                .dueDate(dto.getDueDate())
                .complete(dto.isComplete())
                .build();
    }

    void remove(long id);

    TodoDto getTodoById(Long id);

}
