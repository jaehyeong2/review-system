package jjfactory.common.user.infra.team;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.common.user.domain.QUser;
import jjfactory.common.user.domain.User;
import jjfactory.common.user.domain.team.UserTeamHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jjfactory.common.organization.domain.team.QTeam.*;
import static jjfactory.common.user.domain.QUser.*;
import static jjfactory.common.user.domain.team.QUserTeamHistory.*;

@RequiredArgsConstructor
@Repository
public class UserDslRepository {
    private final JPAQueryFactory queryFactory;

    public UserTeamHistory findTeamIdByUserIdAndYearQuarterId(Long userId, Long yearQuarterId){
        return queryFactory.selectFrom(userTeamHistory)
                .join(team).on(team.id.eq(userTeamHistory.teamId))
                .where(userTeamHistory.user.id.eq(userId),
                        team.yearQuarterId.eq(yearQuarterId)
                        )
                .fetchOne();
    }

    public Page<User> getUsers(Pageable pageable){
        List<User> content = queryFactory.selectFrom(user)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

        Long total = queryFactory.select(user.count())
                .from(user)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetchOne();

        return new PageImpl<>(content, pageable, total);
    }
}
