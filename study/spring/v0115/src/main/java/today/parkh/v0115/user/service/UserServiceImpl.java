package today.parkh.v0115.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import today.parkh.v0115.user.domain.User;
import today.parkh.v0115.user.dto.UserAddDTO;
import today.parkh.v0115.user.dto.UserDTO;
import today.parkh.v0115.user.repository.UserRepository;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO saveUser(UserAddDTO dto) {
        User user = modelMapper.map(dto, User.class);
        User saveUser = userRepository.save(user);
        UserDTO userDTO = modelMapper.map(saveUser, UserDTO.class);

        return userDTO;
    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException();
        });
    }
}
