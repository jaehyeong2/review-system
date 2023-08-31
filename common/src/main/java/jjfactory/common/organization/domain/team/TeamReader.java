package jjfactory.common.organization.domain.team;

import java.util.List;

public interface TeamReader {
    Team get(Long id);
    List<Team> getByOrganizationId(Long organizationId);
}
