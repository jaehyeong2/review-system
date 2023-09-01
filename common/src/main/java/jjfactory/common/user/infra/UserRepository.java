package jjfactory.common.user.infra;

import jjfactory.common.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByTeamId(Long teamId);
}
