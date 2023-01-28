package org.plateer.backlms.common.dto;

import lombok.Data;

@Data
public class ResultDTO<T> {
    private T data;
    private String error;

    private ResultDTO() {
    }

    public ResultDTO(T data) {
        this.data = data;
    }

    public ResultDTO(String error) {
        this.error = error;
    }
}
