package org.parkh.b1.todo.repository.search;

import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.parkh.b1.todo.domain.Todo;
import org.parkh.b1.todo.dto.SearchConditionDTO;
import org.parkh.b1.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Log4j2
class TodoSearchImplTest {
    @Autowired
    private TodoRepository todoRepository;

    private final Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

    @Test
    public void searchList() {
        Page<Todo> todos = todoRepository.searchList(pageable);

        log.info(todos);
        for (Todo todo : todos) {
            Assertions.assertThat(todo).isNotNull();
        }
    }

    @Test
    public void searchListWithCountByKeyword() {
        SearchConditionDTO searchConditionDto = SearchConditionDTO.builder().keyword("hi").build();
        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
        List<Object[]> contents = objects.getContent();
        for (Object[] content : contents) {
            Todo todo = (Todo) content[0];
            int replyCount = (int) content[1];

            Assertions.assertThat(todo).isNotNull();
            Assertions.assertThat(replyCount).isPositive();
        }
    }

    @Test
    public void searchListWithCountByCompletedTrue() {
        SearchConditionDTO searchConditionDto = SearchConditionDTO.builder().completed(true).build();
        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
        List<Object[]> contents = objects.getContent();
        for (Object[] content : contents) {
            Todo todo = (Todo) content[0];
            long replyCount = (long) content[1];


            Assertions.assertThat(todo.isComplete()).isTrue();
            Assertions.assertThat(replyCount).isGreaterThanOrEqualTo(0L);
        }
    }

    @Test
    public void searchListWithCountByCompletedFalse() {
        SearchConditionDTO searchConditionDto = SearchConditionDTO.builder().completed(false).build();
        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
        List<Object[]> contents = objects.getContent();
        for (Object[] content : contents) {
            Todo todo = (Todo) content[0];
            long replyCount = (long) content[1];

            Assertions.assertThat(todo.isComplete()).isFalse();
            Assertions.assertThat(replyCount).isGreaterThanOrEqualTo(0L);
        }
    }

    @Test
    public void searchListWithCountByCompletedFalseAndKeyword() {
        SearchConditionDTO searchConditionDto = SearchConditionDTO.builder()
                .completed(false)
                .keyword("hi")
                .build();

        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
        List<Object[]> contents = objects.getContent();
        for (Object[] content : contents) {
            Todo todo = (Todo) content[0];
            long replyCount = (long) content[1];

            Assertions.assertThat(todo.getTitle().contains("hi")).isTrue();
            Assertions.assertThat(replyCount).isGreaterThanOrEqualTo(0L);
        }
    }

    @Test
    public void searchListWithCountByCompletedTrueAndKeyword() {
        SearchConditionDTO searchConditionDto = SearchConditionDTO.builder()
                .completed(true)
                .keyword("hi")
                .build();

        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);

        List<Object[]> contents = objects.getContent();
        for (Object[] content : contents) {
            Todo todo = (Todo) content[0];
            long replyCount = (long) content[1];

            Assertions.assertThat(todo.isComplete()).isTrue();
            Assertions.assertThat(todo.getTitle().contains("hi")).isTrue();
            Assertions.assertThat(replyCount).isGreaterThanOrEqualTo(0L);
        }
    }

    @Test
    public void searchListWithCountByFrom() {
        LocalDate from = LocalDate.now().minusDays(10);
        SearchConditionDTO searchConditionDto = SearchConditionDTO.builder()
                .from(from)
                .build();

        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);
        log.info(objects);
        List<Object[]> contents = objects.getContent();
        for (Object[] content : contents) {
            Todo todo = (Todo) content[0];
            long replyCount = (long) content[1];
            Assertions.assertThat(todo.getDueDate()).isEqualTo(from);
            Assertions.assertThat(replyCount).isGreaterThanOrEqualTo(0L);
        }
    }

    @Test
    public void searchListWithCountByTo() {
        LocalDate to = LocalDate.now().plusDays(10);
        SearchConditionDTO searchConditionDto = SearchConditionDTO.builder()
                .to(to)
                .build();

        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
        List<Object[]> contents = objects.getContent();
        for (Object[] content : contents) {
            Todo todo = (Todo) content[0];
            long replyCount = (long) content[1];
            Assertions.assertThat(todo.getDueDate()).isEqualTo(to);
            Assertions.assertThat(replyCount).isGreaterThanOrEqualTo(0L);
        }
    }

    @Test
    public void searchListWithCountByFromTo() {
        LocalDate from = LocalDate.now().minusDays(10);
        LocalDate to = LocalDate.now().plusDays(10);
        SearchConditionDTO searchConditionDto = SearchConditionDTO.builder()
                .to(to)
                .from(from)
                .build();

        Page<Object[]> objects = todoRepository.searchListWithCount(pageable, searchConditionDto);

        log.info(objects);
        List<Object[]> contents = objects.getContent();
        for (Object[] content : contents) {
            Todo todo = (Todo) content[0];
            long replyCount = (long) content[1];

            Assertions.assertThat(todo.getDueDate()).isBetween(from, to);
            Assertions.assertThat(replyCount).isGreaterThanOrEqualTo(0L);
        }
    }
}