package org.parkh.b1.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.parkh.b1.todo.dto.TodoListDto;
import org.parkh.b1.todo.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TodoListDto> getList() {

        log.info("-----[get List]-----");

        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        Page<Object[]> result = todoRepository.searchListWithCount(pageable);

        return result.getContent()
                .stream()
                .map(arr -> modelMapper.map(arr, TodoListDto.class))
                .collect(Collectors.toList());
    }
}
