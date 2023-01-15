package today.parkh.v0115.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import today.parkh.v0115.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
