package jjfactory.common.user.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserReader userReader;
    private final UseWriter useWriter;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public Long create(UserCommand.Create command) {
        User initUser = command.toEntity();
        User user = useWriter.write(initUser);

        return user.getId();
    }

    @Transactional
    @Override
    public Long delete(Long id) {
        User user = userReader.get(id);
        user.delete();

        return user.getId();
    }

    @Transactional(readOnly = true)
    @Override
    public UserInfo.DetailResponse get(Long id) {
        return userMapper.of(userReader.get(id));
    }

    @Override
    public Page<UserInfo.ListResponse> getAllUsers(Pageable pageable) {
        return userReader.getUsers(pageable).map(userMapper::ofListResponse);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserInfo.ListResponse> getTeamUsers(Long userId) {
        Long teamId = userReader.get(userId).getTeamId();
        if (teamId == null) return Collections.emptyList();

        return userReader.getUsersByTeamId(teamId).stream()
                .map(userMapper::ofListResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Long update(UserCommand.Update command, Long userId) {
        User user = userReader.get(userId);
        user.update(command);

        return user.getId();
    }
}
