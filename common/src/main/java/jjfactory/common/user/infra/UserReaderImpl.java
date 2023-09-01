package jjfactory.common.user.infra;

import jjfactory.common.user.domain.User;
import jjfactory.common.user.domain.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserReaderImpl implements UserReader {
    private final UserRepository userRepository;

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getUsersByTeamId(Long teamId) {
        return userRepository.findAllByTeamId(teamId);
    }
}
