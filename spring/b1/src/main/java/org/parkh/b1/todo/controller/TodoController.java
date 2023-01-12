package org.parkh.b1.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/todos/")
public class TodoController {

    @GetMapping("/get1")
    public ResponseEntity<Map<String, String>> get1() {
        Map<String, String> map = Map.of("name", "phj", "country", "korea");

        return ResponseEntity.ok(map);
    }
}
