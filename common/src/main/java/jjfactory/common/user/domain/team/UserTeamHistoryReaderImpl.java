package jjfactory.common.user.domain.team;

import jjfactory.common.user.infra.team.UserTeamDslRepository;
import jjfactory.common.user.infra.team.UserTeamHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@RequiredArgsConstructor
@Component
public class UserTeamHistoryReaderImpl implements UserTeamHistoryReader {
    private final UserTeamHistoryRepository userTeamHistoryRepository;
    private final UserTeamDslRepository userTeamDslRepository;
    @Override
    public UserTeamHistory findOneByUserIdAndYearQuarterId(Long userId, Long yearQuarterId){
        return userTeamDslRepository.findTeamIdByUserIdAndYearQuarterId(userId, yearQuarterId);
    }

    @Override
    public List<UserTeamHistory> findAllByTeamId(Long teamId) {
        return userTeamHistoryRepository.findAllByTeamId(teamId);
    }
}