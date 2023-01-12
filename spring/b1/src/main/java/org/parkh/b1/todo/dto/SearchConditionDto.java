package org.parkh.b1.todo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SearchConditionDto {
    String keyword;
    LocalDate from;
    LocalDate to;
    Boolean completed;
}
