package jjfactory.common.user.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    Long create(UserCommand.Create command);

    Long delete(Long id);

    UserInfo.DetailResponse get(Long id);
    Page<UserInfo.ListResponse> getAllUsers(Pageable pageable);

    List<UserInfo.ListResponse> getTeamUsers(Long userId);

    Long update(UserCommand.Update command, Long userId);
}
