package org.parkh.b1.todo.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.parkh.b1.todo.domain.QReply;
import org.parkh.b1.todo.domain.QTodo;
import org.parkh.b1.todo.domain.Todo;
import org.parkh.b1.todo.dto.SearchConditionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {
    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Page<Todo> searchList(Pageable pageable) {
        QTodo todo = QTodo.todo;
        JPQLQuery<Todo> query = from(todo);
        JPQLQuery<Todo> todoJPQLQuery = getQuerydsl().applyPagination(pageable, query);
        List<Todo> todos = todoJPQLQuery.fetch();

        return new PageImpl(todos);
    }

    @Override
    public Page<Todo> searchListByKeyword(Pageable pageable, String keyword) {
        log.info("----------searchList------------");
        QTodo todo = QTodo.todo;
        JPQLQuery<Todo> query = from(todo);

        query.where(todo.title.like(keyword));
        log.info(query);

        getQuerydsl().applyPagination(pageable, query);

        List<Todo> todos = query.fetch();

        return new PageImpl(todos);
    }

    @Override
    public Page<Object[]> searchListWithCount(Pageable pageable) {
        QTodo todo = QTodo.todo;
        QReply reply = QReply.reply;

        JPQLQuery<Todo> query = from(todo).leftJoin(reply);

        // 페이징 처리
        getQuerydsl().applyPagination(pageable, query)
//                .on(reply.todo.id.eq(todo.id));
                .on(reply.todo.eq(todo))
                .groupBy(todo);
        log.info(query);

        JPQLQuery<Tuple> tupleJPQLQuery = query.select(todo, reply.count());

        List<Tuple> tuples = tupleJPQLQuery.fetch();
        long count = tupleJPQLQuery.fetchCount();

        log.info(tuples);
        log.info(count);

        List<Object[]> objects = tuples.stream()
                .map(tuple -> tuple.toArray())
                .collect(Collectors.toList());

        return new PageImpl(objects, pageable, count);
    }

    @Override
    public Page<Object[]> searchListWithCount(Pageable pageable, SearchConditionDto searchConditionDto) {
        QTodo todo = QTodo.todo;
        QReply reply = QReply.reply;

        JPQLQuery<Todo> query = from(todo).leftJoin(reply);

        // 검색 조건 처리
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        LocalDate from = searchConditionDto.getFrom();
        LocalDate to = searchConditionDto.getTo();
        String keyword = searchConditionDto.getKeyword();
        Boolean completed = searchConditionDto.getCompleted();

        // boolean builder 사용하면 더 깔끔하게 코딩 가능
        if (keyword != null) {
            booleanBuilder.and(todo.title.contains(keyword));
        }

        if (completed != null) {
            booleanBuilder.and(todo.complete.eq(completed));
        }

        if (from != null || to != null) {
            if (from == null) {
                from = LocalDate.now();
            }
            if (to == null) {
                to = LocalDate.now();
            }
            booleanBuilder.and(todo.dueDate.between(from, to));
        }
        query.where(booleanBuilder);

        // 페이징 처리
        getQuerydsl().applyPagination(pageable, query)
                .on(reply.todo.eq(todo))
                .groupBy(todo);
        log.info(query);

        JPQLQuery<Tuple> tupleJPQLQuery = query.select(todo, reply.count());
        List<Tuple> tuples = tupleJPQLQuery.fetch();
        long count = tupleJPQLQuery.fetchCount();

        List<Object[]> objects = tuples.stream()
                .map(tuple -> tuple.toArray())
                .collect(Collectors.toList());

        return new PageImpl(objects, pageable, count);
    }


    public Page<Object[]> searchListWithCountDto(Pageable pageable, SearchConditionDto searchConditionDto) {
        QTodo todo = QTodo.todo;
        QReply reply = QReply.reply;

        JPQLQuery<Todo> query = from(todo).leftJoin(reply);

        // 검색 조건 처리
        LocalDate from = searchConditionDto.getFrom();
        LocalDate to = searchConditionDto.getTo();
        String keyword = searchConditionDto.getKeyword();
        Boolean completed = searchConditionDto.getCompleted();

        // boolean builder 사용하면 더 깔끔하게 코딩 가능
        if (keyword != null) {
            query.where(todo.title.contains(keyword));
        }

        if (completed != null) {
            query.where(todo.complete.eq(completed));
        }

        if (from != null || to != null) {
            if (from == null) {
                from = LocalDate.now();
            }
            if (to == null) {
                to = LocalDate.now();
            }
            query.where(todo.dueDate.between(from, to));
        }

        // 페이징 처리
        getQuerydsl().applyPagination(pageable, query)
                .on(reply.todo.eq(todo))
                .groupBy(todo);
        log.info(query);

        JPQLQuery<Tuple> tupleJPQLQuery = query.select(todo, reply.count());
        List<Tuple> tuples = tupleJPQLQuery.fetch();
        long count = tupleJPQLQuery.fetchCount();

        List<Object[]> objects = tuples.stream()
                .map(tuple -> tuple.toArray())
                .collect(Collectors.toList());

        return new PageImpl(objects, pageable, count);
    }
}

// 인터페이스 정의
// 인터페이스 구현
// 원래 인터페이스에 추가