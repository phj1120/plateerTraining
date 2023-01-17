package com.plateer.todo.todo.repository;

import com.plateer.todo.todo.dto.TodoSearchDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.plateer.todo.todo.domain.Todo;
import com.plateer.todo.todo.dto.TodoListDTO;

import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testDelete() {

        Long tno = 1L;

        todoRepository.deleteById(tno);
    }

    @Test
    public void testPaging(){

        Pageable pageable = PageRequest.of(1,10, Sort.by("id").descending());

        Page<Todo> result = todoRepository.findAll(pageable);

        log.info(result);

        log.info(result.getTotalElements());

        log.info(result.getNumber());
    }

    @Test
    public void testListWithCount() {

        Pageable pageable =
                PageRequest.of(0,10,
                        Sort.by("id").descending());

        Page<Object[]> result = todoRepository.listWithCount(pageable);
    }

    @Test
    public void testQuerydsl() {
        Pageable pageable =
                PageRequest.of(0,10,
                        Sort.by("id").descending());

        Page<Todo> result = todoRepository.searchList(pageable,"5");

        log.info(result);

    }

    @Test
    public void testQuerydslWithCount() {
        Pageable pageable =
                PageRequest.of(0,10,
                        Sort.by("id").descending());

        Page<Object[]> result = todoRepository.searchListWithCount(pageable);

        log.info(result);

    }

    @Test
    public void testInserts() {
        IntStream.rangeClosed(1,100).forEach((i) -> {

            Todo todo = Todo.builder()
                    .title("Title.."+i)
                    .writer("user"+i)
                    .dueDate(LocalDate.now().plusDays( i % 5 ))
                    .build();

            log.info(todoRepository.save(todo));

        });//end loop
    }

    @Test
    public void testSearch2() {


        Pageable pageable =
                PageRequest.of(0,10,
                        Sort.by("id").descending());


        TodoSearchDTO todoSearchDTO = TodoSearchDTO.builder()
                //.keyword("1")
                .from(LocalDate.now())
                .to(LocalDate.now().plusDays(100))
                //.finish(true)
                .build();

        Page<TodoListDTO> result = todoRepository.searchListWithCount2(pageable, todoSearchDTO);




    }

}




