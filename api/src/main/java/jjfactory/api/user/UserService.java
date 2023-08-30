package jjfactory.api.user;

import jjfactory.common.user.domain.User;

import java.util.List;

public interface UserService {
    Long create();
    Long delete();
    User get(Long id);
    List<User> getList();
}
