package org.zerock.b1.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.b1.todo.domain.Todo;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long id;

    private String title;

    private String writer;

    private LocalDate dueDate;

    private boolean complete;

    private LocalDate regDate;

    private LocalDate modDate;



}









