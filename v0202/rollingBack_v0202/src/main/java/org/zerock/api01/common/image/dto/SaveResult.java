package org.zerock.api01.common.image.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SaveResult {
    @Data
    @NoArgsConstructor
    static class Success {
        int index;
        String path;

        public Success(int index, String path) {
            this.index = index;
            this.path = path;
        }
    }

    private List<Success> success = new ArrayList<>();
    private List<Integer> fail = new ArrayList<>();

    public void success(int index, String savedPath) {
        success.add(new Success(index, savedPath));
    }

    public void fail(int index) {
        fail.add(index);
    }
}
