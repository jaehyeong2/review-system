package jjfactory.common.user.domain.team;

import java.util.List;

public interface UserTeamHistoryReader {
    UserTeamHistory findOneByUserIdAndYearQuarterId(Long userId, Long yearQuarterId);
    List<UserTeamHistory> findAllByTeamId(Long teamId);
}
