package jjfactory.common.user.infra.team;

import jjfactory.common.user.domain.team.UserTeamHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTeamHistoryRepository extends JpaRepository<UserTeamHistory, Long> {
    List<UserTeamHistory> findAllByTeamId(Long teamId);
    List<UserTeamHistory> findAllByTeamIdAndUserIdNot(Long teamId, Long userId);
}