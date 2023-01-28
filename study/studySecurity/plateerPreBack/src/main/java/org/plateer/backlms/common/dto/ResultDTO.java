package org.plateer.backlms.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultDTO<T> {
    private T data;
    private String error;

    public ResultDTO(T data) {
        this.data = data;
    }

    public ResultDTO(String error) {
        this.error = error;
    }
}
