package org.parkh.b1.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.parkh.b1.common.domain.dto.PageResultDTO;
import org.parkh.b1.todo.domain.Todo;
import org.parkh.b1.todo.dto.SearchConditionDto;
import org.parkh.b1.todo.dto.TodoAddDTO;
import org.parkh.b1.todo.dto.TodoDto;
import org.parkh.b1.todo.dto.TodoListDTO;
import org.parkh.b1.todo.repository.TodoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

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

   /* @Override
    public void add(TodoDto dto) {
        Todo entity = getEntity(dto);
//        Todo entity = modelMapper.map(dto, Todo.class) // 커스터마이징 해야될 때 적합하지 않음 ex 첨부파일

        todoRepository.save(entity);
    }*/


    public PageResultDTO<TodoListDTO> getList() {
        log.info("================getlist================");
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        Page<Object[]> result = todoRepository.searchListWithCount(pageable);
/*
        return result.getContent().stream()
                .map(arr -> modelMapper.map(arr, TodoListDTO.class))
                .collect(Collectors.toList());
*/
        List<TodoListDTO> lst = result.getContent().stream().map(arr -> {
            Todo entity = (Todo) arr[0];
            long count = (long) arr[1];
            TodoListDTO todoListDTO = modelMapper.map(entity, TodoListDTO.class);
            todoListDTO.setReplyCount(count);
            return todoListDTO;
        }).collect(Collectors.toList());

        PageResultDTO<TodoListDTO> pageResultDTO = new PageResultDTO<TodoListDTO>(lst, pageable, result.getTotalElements(), result.getTotalPages());

        return pageResultDTO;
    }

    public PageResultDTO<TodoListDTO> getList(SearchConditionDto conditionDto) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        Page<Object[]> result = todoRepository.searchListWithCount(pageable, conditionDto);

        List<TodoListDTO> lst = result.getContent().stream().map(arr -> {
            Todo entity = (Todo) arr[0];
            long count = (long) arr[1];
            TodoListDTO todoListDTO = modelMapper.map(entity, TodoListDTO.class);
            todoListDTO.setReplyCount(count);
            return todoListDTO;
        }).collect(Collectors.toList());


        PageResultDTO<TodoListDTO> pageResultDTO = new PageResultDTO<TodoListDTO>(lst, pageable, result.getTotalElements(), result.getTotalPages());


        return pageResultDTO;
    }

    @Override
    public void remove(long id) {
        try {
            todoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new RuntimeException();
        }
    }

    @Override
    public TodoDto getTodoById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();

        return modelMapper.map(todo, TodoDto.class);
    }

    public TodoDto add(TodoAddDTO todoAddDto) {
        TodoDto todoDto = TodoDto.builder()
                .title(todoAddDto.getTitle())
                .writer(todoAddDto.getWriter())
                .dueDate(todoAddDto.getDueDate())
                .complete(false)
                .build();

        Todo result = todoRepository.save(todoDto.getEntity());
        return modelMapper.map(result, TodoDto.class);
    }
//    @Override
//    public List<TodoListDto> getList() {
//        log.info("-----[get List]-----");
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());
//        Page<Object[]> result = todoRepository.searchListWithCount(pageable);
//
//        return result.getContent().stream().map(arr -> {
//            Todo entity = (Todo) arr[0];
//            long count = (long) arr[1];
//            TodoListDto dto = modelMapper.map(entity, TodoListDto.class);
//            dto.setReplyCount(count);
//
//            return dto;
//        }).collect(Collectors.toList());
//    }
//
//
//    // TODO 추가하기
//    @Override
//    public List<TodoListDto> getList(SearchConditionDto searchConditionDto) {
//        log.info("-----[get List]-----");
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());
//        Page<Object[]> result = todoRepository.searchListWithCount(pageable, searchConditionDto);
//
//
//        return null;
//    }
//

}
