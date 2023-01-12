package org.parkh.b1.todo.repository.search;

import org.parkh.b1.todo.domain.Todo;
import org.parkh.b1.todo.dto.SearchConditionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoSearch {

    Page<Todo> searchList(Pageable pageable);

    Page<Todo> searchListByKeyword(Pageable pageable, String Keyword);

    Page<Object[]> searchListWithCount(Pageable pageable);

    Page<Object[]> searchListWithCount(Pageable pageable, SearchConditionDto searchConditionDto);

}
