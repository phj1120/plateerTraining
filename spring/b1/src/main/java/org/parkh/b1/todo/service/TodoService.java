package org.parkh.b1.todo.service;

import org.parkh.b1.common.domain.dto.PageResultDTO;
import org.parkh.b1.common.domain.dto.ResultDTO;
import org.parkh.b1.todo.domain.Todo;
import org.parkh.b1.todo.dto.*;

public interface TodoService {
    default Todo getEntity(TodoDTO dto) {
        return Todo.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .writer(dto.getWriter())
                .dueDate(dto.getDueDate())
                .complete(dto.isComplete())
                .build();
    }

    ResultDTO<TodoDTO> add(TodoAddDTO dto);

    ResultDTO<TodoDTO> getTodo(Long id);

    PageResultDTO<TodoListDTO> getTodos();

    PageResultDTO<TodoListDTO> getTodos(SearchConditionDTO dto);

    ResultDTO<TodoDeleteDto> remove(long id);
}
