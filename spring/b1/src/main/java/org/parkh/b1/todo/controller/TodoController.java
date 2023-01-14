package org.parkh.b1.todo.controller;

import lombok.RequiredArgsConstructor;
import org.parkh.b1.common.domain.dto.PageResultDTO;
import org.parkh.b1.common.domain.dto.ResultDTO;
import org.parkh.b1.todo.dto.*;
import org.parkh.b1.todo.service.TodoService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public PageResultDTO<TodoListDTO> getTodoListDTO(@Valid @ModelAttribute SearchConditionDTO dto, BindingResult bindingResult) {

        return todoService.getTodos(dto);
    }

    @GetMapping("/{id}")
    public ResultDTO<TodoDTO> getTodoListDTO(@PathVariable("id") Long id) {

        return todoService.getTodo(id);
    }

    @PostMapping
    public ResultDTO<TodoDTO> addTodo(@Valid @RequestBody TodoAddDTO todoAddDto, BindingResult bindingResult) {

        return todoService.add(todoAddDto);
    }

    @DeleteMapping("/{id}")
    public ResultDTO<TodoDeleteDto> delete(@PathVariable("id") long id) {

        return todoService.remove(id);
    }

}
