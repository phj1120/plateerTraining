package org.zerock.b1.todo.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.b1.common.dto.PageResultDTO;
import org.zerock.b1.todo.domain.Todo;
import org.zerock.b1.todo.dto.TodoDTO;
import org.zerock.b1.todo.dto.TodoListDTO;
import org.zerock.b1.todo.dto.TodoSearchDTO;
import org.zerock.b1.todo.repository.TodoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class TodoServieImpl implements TodoService{

    private final TodoRepository todoRepository;

    private final ModelMapper modelMapper;

    @Override
    public void add(TodoDTO todoDTO) {

        //Todo entity = getEntity(todoDTO);

        Todo entity = modelMapper.map(todoDTO, Todo.class);

        todoRepository.save(entity);

    }

    @Override
    public PageResultDTO<TodoListDTO> getList() {

        log.info("getList....................");

        Pageable pageable = PageRequest.of(0,10, Sort.by("id").descending());

        Page<Object[]> result = todoRepository.searchListWithCount(pageable);

        //List<Object[]>
        List<TodoListDTO> list = result.getContent().stream().map(arr -> {

            Todo entity = (Todo)arr[0];
            long count = (long)arr[1];
            TodoListDTO dto = modelMapper.map(entity, TodoListDTO.class);
            dto.setReplyCount(count);

            return dto;
        }).collect(Collectors.toList());

        PageResultDTO<TodoListDTO> pageResultDTO =
                new PageResultDTO<>(list,pageable, result.getTotalElements(), result.getTotalPages() );

        return pageResultDTO;

    }

}
