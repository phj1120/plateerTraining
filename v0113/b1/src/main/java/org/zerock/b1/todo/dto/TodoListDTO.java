package org.zerock.b1.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoListDTO {

    private Long id;
    private String title;
    private String writer;
    private long replyCount;
}
