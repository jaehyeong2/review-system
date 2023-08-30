package jjfactory.common.user.infra;

import jjfactory.common.user.domain.User;
import jjfactory.common.user.domain.UserReader;
import jjfactory.common.user.infra.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserReaderImpl implements UserReader {
    private final UserRepository userRepository;
    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
