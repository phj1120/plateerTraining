package org.parkh.b1.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchConditionDto {
    String keyword;
    LocalDate from;
    LocalDate to;
    Boolean completed;
}
