package org.parkh.b1.todo.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.parkh.b1.todo.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testInsert() {
        LocalDate date = LocalDate.now().minusDays(50);

        IntStream.rangeClosed(1, 100).forEach((i) -> {
            Todo todo = Todo.builder()
                    .title("Title" + i)
                    .writer("user" + i)
                    .dueDate(date.plusDays(i))
                    .build();
            log.info(todoRepository.save(todo));
        });
    }

    @Test
    public void testDelete() {
        Long tno = 1L;
        todoRepository.deleteById(tno);

    }

    @Test
    public void testPaging() {
        // 도메인 기준으로 반환
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        // 개수가 size 보다 적으면 count 후속 쿼리가 안나감
        Page<Todo> todos = todoRepository.findAll(pageable);

        log.info(todos);
        log.info(todos.getTotalElements());
        log.info(todos.getTotalPages());
        log.info(todos.getNumber());
    }

    @Test
    public void testListWithCount() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        Page<Object[]> objects = todoRepository.listWithCount(pageable);
        log.info(objects);
    }

    @Test
    public void testQueryDsl() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());
        Page<Todo> todos = todoRepository.searchListByKeyword(pageable, "5");

        log.info(todos);
    }

    @Test
    public void testQueryDslWithReadCount() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());
        Page<Object[]> result = todoRepository.searchListWithCount(pageable);

        log.info(result);
    }
}