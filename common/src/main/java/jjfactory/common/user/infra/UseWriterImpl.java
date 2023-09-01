package jjfactory.common.user.infra;

import jjfactory.common.user.domain.UseWriter;
import jjfactory.common.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UseWriterImpl implements UseWriter {
    private final UserRepository userRepository;

    @Override
    public User write(User user) {
        return userRepository.save(user);
    }
}
