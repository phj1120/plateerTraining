package com.plateer.todo.todo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long id;

    private String title;

    private String writer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    private boolean complete;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate regDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate modDate;



}









