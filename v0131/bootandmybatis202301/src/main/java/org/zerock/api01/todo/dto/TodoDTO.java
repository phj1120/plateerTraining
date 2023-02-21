package org.zerock.api01.todo.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TodoDTO {

    private Long tno;

    private String title;

}
