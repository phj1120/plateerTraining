package org.parkh.b1.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.parkh.b1.common.domain.dto.PageResultDTO;
import org.parkh.b1.common.domain.dto.ResultDTO;
import org.parkh.b1.todo.domain.Todo;
import org.parkh.b1.todo.dto.*;
import org.parkh.b1.todo.repository.ReplyRepository;
import org.parkh.b1.todo.repository.TodoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
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
    private final ReplyRepository replyRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResultDTO<TodoDTO> add(TodoAddDTO todoAddDto) {
        TodoDTO todoDTO = modelMapper.map(todoAddDto, TodoDTO.class); // 커스터마이징 해야될 때 적합하지 않음 ex 첨부파일
        Todo todo = getEntity(todoDTO);
        Todo saveTodo = todoRepository.save(todo);
        TodoDTO saveTodoDTO = modelMapper.map(saveTodo, TodoDTO.class);

        return ResultDTO.<TodoDTO>builder().data(saveTodoDTO).build();
    }

    @Override
    public ResultDTO<TodoDTO> getTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        TodoDTO todoDTO = modelMapper.map(todo, TodoDTO.class);

        return ResultDTO.<TodoDTO>builder().data(todoDTO).build();
    }

    @Override
    public PageResultDTO<TodoListDTO> getTodos() {
        // 아직 Pageable 을 파라미터로 안받았기 때문에.
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        // Object[] 으로 Todo, count 가 담겨서 반환됨
        Page<Object[]> result = todoRepository.searchListWithCount(pageable);

        // Object 배열을 원하는 형식인 TodoListDTO 로 변환
        List<TodoListDTO> todoListDTOS = convertTodoListDTOList(result.getContent());

        return new PageResultDTO<TodoListDTO>(todoListDTOS, pageable, result.getTotalElements(), result.getTotalPages());
    }

    @Override
    public PageResultDTO<TodoListDTO> getTodos(SearchConditionDTO conditionDto) {
        // 아직 Pageable 을 파라미터로 안받았기 때문에.
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        Page<Object[]> result = todoRepository.searchListWithCount(pageable, conditionDto);

        List<TodoListDTO> lst = convertTodoListDTOList(result.getContent());

        return new PageResultDTO<TodoListDTO>(lst, pageable, result.getTotalElements(), result.getTotalPages());
    }

    @Override
    public ResultDTO<TodoDeleteDto> remove(long id) {
        try {
            // 관련 된 댓글 삭제
            Todo todo = todoRepository.findById(id)
                    .orElseThrow(() -> {
                        throw new RuntimeException();
                    });
            replyRepository.deleteByTodo(todo);
            todoRepository.delete(todo);
        } catch (EmptyResultDataAccessException exception) {
            throw new RuntimeException();
        }

        return ResultDTO
                .<TodoDeleteDto>builder()
                .data(TodoDeleteDto
                        .builder()
                        .state(true)
                        .build())
                .build();
    }

    private List<TodoListDTO> convertTodoListDTOList(List<Object[]> contents) {
        return contents.stream().map(arr -> {
            Todo todo = (Todo) arr[0];
            long count = (long) arr[1];
            TodoListDTO todoListDTO = modelMapper.map(todo, TodoListDTO.class);
            todoListDTO.setReplyCount(count);

            return todoListDTO;
        }).collect(Collectors.toList());
    }
}
