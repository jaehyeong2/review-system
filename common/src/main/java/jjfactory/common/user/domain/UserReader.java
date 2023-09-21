package jjfactory.common.user.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserReader {
    User get(Long id);
    List<User> getUsersByTeamId(Long teamId);
    Page<User> getUsers(Pageable pageable);
}
