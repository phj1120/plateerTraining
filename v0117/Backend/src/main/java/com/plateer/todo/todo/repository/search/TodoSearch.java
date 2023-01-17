package com.plateer.todo.todo.repository.search;

import com.plateer.todo.todo.domain.Todo;
import com.plateer.todo.todo.dto.TodoListDTO;
import com.plateer.todo.todo.dto.TodoSearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoSearch {

    Page<Todo> searchList(Pageable pageable, String keyword);

    Page<Object[]> searchListWithCount(Pageable pageable);

    Page<TodoListDTO> searchListWithCount2(Pageable pageable, TodoSearchDTO searchDTO);

}
