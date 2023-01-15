package today.parkh.v0115.user.dto;

import lombok.Data;

@Data
public class UserAddDTO {
    private String name;

    public UserAddDTO(String name) {
        this.name = name;
    }
}
