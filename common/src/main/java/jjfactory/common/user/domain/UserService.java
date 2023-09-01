package jjfactory.common.user.domain;

import java.util.List;

public interface UserService {
    Long create(UserCommand.Create command);
    Long delete(Long id);
    UserInfo.DetailResponse get(Long id);
    List<UserInfo.ListResponse> getTeamUsers(Long userId);
    Long update(UserCommand.Update command, Long userId);
}
