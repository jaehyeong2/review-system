package jjfactory.api.user;

import jjfactory.common.user.domain.User;
import jjfactory.common.user.infra.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public Long create() {
        return null;
    }

    @Override
    public Long delete() {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public List<User> getList() {
        return null;
    }
}
