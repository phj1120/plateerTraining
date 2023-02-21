package org.zerock.b1.todo.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.zerock.b1.common.dto.PageResultDTO;
import org.zerock.b1.todo.dto.TodoAddDTO;
import org.zerock.b1.todo.dto.TodoListDTO;
import org.zerock.b1.todo.dto.TodoSearchDTO;
import org.zerock.b1.todo.service.TodoService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos/")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Log4j2
public class TodoController {

    private final TodoService todoService;

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, String> add(@Valid @RequestBody TodoAddDTO dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("has error");
            throw new RuntimeException("binding exception");
        }
        log.info(dto);

        return Map.of("result","success");

    }


    @GetMapping("get1")
    public ResponseEntity<Map<String, String>> get1(){

        Map<String, String> result = Map.of("name","Hong Gil Dong", "country", "Chosun");

        return ResponseEntity.ok(result);
    }

    @GetMapping("get2")
    public PageResultDTO<TodoListDTO> getList() {

        return todoService.getList();
    }



}
