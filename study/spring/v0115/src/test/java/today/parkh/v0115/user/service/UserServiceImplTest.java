package today.parkh.v0115.user.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import today.parkh.v0115.user.dto.UserAddDTO;
import today.parkh.v0115.user.dto.UserDTO;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        String name = "name";
        UserAddDTO userAddDTO = new UserAddDTO(name);
        UserDTO userDTO = userService.saveUser(userAddDTO);

        Assertions.assertThat(userDTO.getName()).isEqualTo(name);
    }

}