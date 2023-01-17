package com.plateer.todo.todo.service;

import com.plateer.todo.common.dto.PageReqDTO;
import com.plateer.todo.common.dto.PageResultDTO;
import com.plateer.todo.todo.domain.Todo;
import com.plateer.todo.todo.dto.TodoAddDTO;
import com.plateer.todo.todo.dto.TodoDTO;
import com.plateer.todo.todo.dto.TodoListDTO;

public interface TodoService {

    TodoDTO add(TodoAddDTO todoAddDTO);

    PageResultDTO<TodoListDTO> getList(PageReqDTO pageReqDTO);

    TodoDTO getOne(Long id);

    void remove(Long id);

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







