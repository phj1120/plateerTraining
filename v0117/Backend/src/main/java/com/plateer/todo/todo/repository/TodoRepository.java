package com.plateer.todo.todo.repository;

import com.plateer.todo.todo.domain.Todo;
import com.plateer.todo.todo.repository.search.TodoSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {



    @Query(value = "select todo, count(reply) " +
            " from Todo todo left join  Reply reply on reply.todo = todo" +
            " group by todo"
            ,
            countQuery = "select count(todo) from Todo todo")
    Page<Object[]> listWithCount(Pageable pageable);
}
