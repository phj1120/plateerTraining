package org.parkh.b1.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoListDto {
    private Long id;
    private String title;
    private String writer;
    private int replyCount;
}
