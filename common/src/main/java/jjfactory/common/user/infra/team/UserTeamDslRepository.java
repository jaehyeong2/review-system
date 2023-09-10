package jjfactory.common.user.infra.team;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.common.user.domain.team.UserTeamHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static jjfactory.common.organization.domain.team.QTeam.*;
import static jjfactory.common.user.domain.team.QUserTeamHistory.*;

@RequiredArgsConstructor
@Repository
public class UserTeamDslRepository {
    private final JPAQueryFactory queryFactory;

    public UserTeamHistory findTeamIdByUserIdAndYearQuarterId(Long userId, Long yearQuarterId){
        return queryFactory.selectFrom(userTeamHistory)
                .join(team).on(team.id.eq(userTeamHistory.teamId))
                .where(userTeamHistory.user.id.eq(userId),
                        team.yearQuarterId.eq(yearQuarterId)
                        )
                .fetchOne();
    }
}
