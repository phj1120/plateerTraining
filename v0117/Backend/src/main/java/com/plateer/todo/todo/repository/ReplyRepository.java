package com.plateer.todo.todo.repository;

import com.plateer.todo.todo.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Modifying
    @Query("delete from Reply r where r.todo.id = :todoId")
    void deleteWithTodo(@Param("todoId") Long todoId);

}
