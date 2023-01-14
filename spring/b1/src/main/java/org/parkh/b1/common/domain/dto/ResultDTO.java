package org.parkh.b1.common.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultDTO<T> {
    private T data;
    private String error;
}
