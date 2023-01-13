package org.parkh.b1.todo.controller;

import lombok.RequiredArgsConstructor;
import org.parkh.b1.common.domain.dto.PageResultDTO;
import org.parkh.b1.todo.domain.Todo;
import org.parkh.b1.todo.dto.*;
import org.parkh.b1.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/todos/")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/get1")
    public ResponseEntity<Map<String, String>> get1() {
        Map<String, String> map = Map.of("name", "phj", "country", "korea");

        return ResponseEntity.ok(map);
    }

    @GetMapping("/get2")
    public PageResultDTO<TodoListDTO> get2() {
        return todoService.getList();
    }

    @GetMapping
    public PageResultDTO<TodoListDTO> getTodoListDTO(@Valid @RequestBody SearchConditionDto dto) {
        return todoService.getList(dto);
    }


    @PostMapping
    public TodoDto addTodo(@Valid @RequestBody TodoAddDTO todoAddDto, BindingResult bindingResult) {
        return todoService.add(todoAddDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long id) {
        todoService.remove(id);

        return ResponseEntity.ok(true);
    }

    @GetMapping("/{id}")
    public TodoDto getTodoListDTO(@PathVariable("id") Long id) {
        return todoService.getTodoById(id);
    }




}
