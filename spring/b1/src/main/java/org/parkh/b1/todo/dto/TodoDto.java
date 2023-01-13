package org.parkh.b1.todo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.parkh.b1.todo.domain.Todo;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {

    public Long id;
    private String title;
    private String writer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    private boolean complete;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate regDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate modDate;

    public Todo getEntity() {
        return Todo.builder()
                .id(this.id)
                .title(this.title)
                .writer(this.writer)
                .dueDate(this.dueDate)
                .complete(this.complete)
                .build();
    }

    public TodoDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.writer = todo.getWriter();
        this.dueDate = todo.getDueDate();
        this.complete = todo.isComplete();
    }
}
