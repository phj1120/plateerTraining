package org.parkh.b1.todo.repository.search;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.parkh.b1.todo.domain.Todo;
import org.parkh.b1.todo.dto.SearchConditionDto;
import org.parkh.b1.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
class TodoSearchImplTest {
    @Autowired
    private TodoRepository todoRepository;

    private final Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

    @Test
    public void searchList() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        Page<Todo> todos = todoRepository.searchList(pageable);

        log.info(todos);
    }

//    String Keyword;
//    LocalDate from;
//    LocalDate to;
//    Boolean completed;

    @Test
    public void searchListWithCountByKeyword() {
        SearchConditionDto searchConditionDto = SearchConditionDto.builder().keyword("hi").build();
        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
    }

    @Test
    public void searchListWithCountByCompletedTrue() {
        SearchConditionDto searchConditionDto = SearchConditionDto.builder().completed(true).build();
        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
    }

    @Test
    public void searchListWithCountByCompletedFalse() {
        SearchConditionDto searchConditionDto = SearchConditionDto.builder().completed(false).build();
        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
    }

    @Test
    public void searchListWithCountByCompletedFalseAndKeyword() {
        SearchConditionDto searchConditionDto = SearchConditionDto.builder()
                .completed(false)
                .keyword("hi")
                .build();

        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
    }

    @Test
    public void searchListWithCountByCompletedTrueAndKeyword() {
        SearchConditionDto searchConditionDto = SearchConditionDto.builder()
                .completed(true)
                .keyword("hi")
                .build();

        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
    }

    @Test
    public void searchListWithCountByFrom() {
        SearchConditionDto searchConditionDto = SearchConditionDto.builder()
                .from(LocalDate.now().minusDays(10))
                .build();

        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
    }

    @Test
    public void searchListWithCountByTo() {
        SearchConditionDto searchConditionDto = SearchConditionDto.builder()
                .to(LocalDate.now().plusDays(10))
                .build();

        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
    }


}