package jjfactory.common.user.infra.team;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.common.user.domain.User;
import jjfactory.common.user.domain.UserCondition;
import jjfactory.common.user.domain.team.UserTeamHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static jjfactory.common.organization.domain.QOrganization.*;
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

    public Page<User> getUsers(Pageable pageable, UserCondition condition){
        List<User> content = queryFactory.selectFrom(user)
                .join(team).on(user.teamId.eq(team.id))
                .join(organization).on(team.organization.eq(organization))
                .where(userNameContains(condition),
                        userEmpNumContains(condition),
                        teamNameContains(condition),
                        organizationNameContains(condition))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

        Long total = queryFactory.select(user.count())
                .from(user)
                .join(team).on(user.teamId.eq(team.id))
                .join(organization).on(team.organization.eq(organization))
                .where(userNameContains(condition),
                        userEmpNumContains(condition),
                        teamNameContains(condition),
                        organizationNameContains(condition))
                .from(user)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetchFirst();

        return new PageImpl<>(content, pageable, total);
    }

    private static BooleanExpression organizationNameContains(UserCondition condition) {
        if (condition == null || !StringUtils.hasText(condition.getOrganizationName())) return null;
        return organization.name.contains(condition.getOrganizationName());
    }

    private static BooleanExpression teamNameContains(UserCondition condition) {
        if (condition == null || !StringUtils.hasText(condition.getTeamName())) return null;
        return team.name.contains(condition.getTeamName());
    }

    private static BooleanExpression userEmpNumContains(UserCondition condition) {
        if (condition == null || !StringUtils.hasText(condition.getEmployeeNumber())) return null;
        return user.employeeNumber.contains(condition.getEmployeeNumber());
    }

    private static BooleanExpression userNameContains(UserCondition condition) {
        if (condition == null || !StringUtils.hasText(condition.getName())) return null;
        return user.name.contains(condition.getName());
    }
}
