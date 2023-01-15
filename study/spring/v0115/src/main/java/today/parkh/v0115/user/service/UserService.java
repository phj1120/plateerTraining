package today.parkh.v0115.user.service;

import today.parkh.v0115.user.domain.User;
import today.parkh.v0115.user.dto.UserAddDTO;
import today.parkh.v0115.user.dto.UserDTO;

import javax.transaction.Transactional;

@Transactional
public interface UserService {
    UserDTO saveUser(UserAddDTO dto);

    User findById(Long id);
}
