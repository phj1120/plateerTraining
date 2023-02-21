package org.zerock.b1.todo.service;

import org.zerock.b1.common.dto.PageResultDTO;
import org.zerock.b1.todo.domain.Todo;
import org.zerock.b1.todo.dto.TodoDTO;
import org.zerock.b1.todo.dto.TodoListDTO;
import org.zerock.b1.todo.dto.TodoSearchDTO;

import java.util.List;

public interface TodoService {

    void add(TodoDTO todoDTO);

    PageResultDTO<TodoListDTO> getList();

    default Todo getEntity(TodoDTO dto){

        Todo todo = Todo.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .writer(dto.getWriter())
                .dueDate(dto.getDueDate())
                .complete(dto.isComplete())
                .build();
        return todo;
    }
}







