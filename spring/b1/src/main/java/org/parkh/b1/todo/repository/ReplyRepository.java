package org.parkh.b1.todo.repository;

import org.parkh.b1.todo.domain.Reply;
import org.parkh.b1.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Query(value = "delete from Reply reply where reply.todo = :todo")
    @Modifying
    void deleteByTodo(@Param("todo") Todo todo);
//    void deleteByTodo(Todo todo);
}
