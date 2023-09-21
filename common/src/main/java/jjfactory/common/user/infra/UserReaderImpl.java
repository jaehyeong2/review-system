package jjfactory.common.user.infra;

import jjfactory.common.global.exception.ResourceNotFoundException;
import jjfactory.common.user.domain.User;
import jjfactory.common.user.domain.UserCondition;
import jjfactory.common.user.domain.UserReader;
import jjfactory.common.user.infra.team.UserDslRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserReaderImpl implements UserReader {
    private final UserRepository userRepository;
    private final UserDslRepository userDslRepository;

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("user not found");
        });
    }

    @Override
    public List<User> getUsersByTeamId(Long teamId) {
        return userRepository.findAllByTeamId(teamId);
    }

    @Override
    public Page<User> getUsers(Pageable pageable, UserCondition condition){
        return userDslRepository.getUsers(pageable, condition);
    }
}
