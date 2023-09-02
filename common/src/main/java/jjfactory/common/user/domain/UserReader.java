package jjfactory.common.user.domain;

import java.util.List;

public interface UserReader {
    User get(Long id);

    List<User> getUsersByTeamId(Long teamId);
}
