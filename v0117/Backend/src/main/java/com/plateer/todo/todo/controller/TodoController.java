package com.plateer.todo.todo.controller;


import com.plateer.todo.common.annotations.JWTAuth;
import com.plateer.todo.common.dto.PageReqDTO;
import com.plateer.todo.common.dto.PageResultDTO;
import com.plateer.todo.todo.dto.TodoAddDTO;
import com.plateer.todo.todo.dto.TodoDTO;
import com.plateer.todo.todo.dto.TodoListDTO;
import com.plateer.todo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/todos/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Log4j2
public class TodoController {

    private final TodoService todoService;

    @JWTAuth
    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public TodoDTO add(@Valid @RequestBody TodoAddDTO dto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("has error");

            throw new RuntimeException("binding exception");
        }
        log.info(dto);

        return todoService.add(dto);

    }

    @GetMapping("list")
    public PageResultDTO<TodoListDTO> getList(PageReqDTO pageReqDTO) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return todoService.getList(pageReqDTO);
    }

    @JWTAuth
    @GetMapping("{id}")
    public TodoDTO get(@PathVariable Long id) {

        log.info(todoService.getClass().getName());

        return todoService.getOne(id);
    }

    @JWTAuth
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

        log.info("--------------------todo delete.............");
        log.info(id);

        todoService.remove(id);
    }
}












