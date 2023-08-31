package jjfactory.common.organization.infra.team;

import jjfactory.common.organization.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findAllByOrganizationId(Long organizationId);
}