package jjfactory.common.organization.infra.team;

import jjfactory.common.organization.domain.team.Team;
import jjfactory.common.organization.domain.team.TeamReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TeamReaderImpl implements TeamReader {
    private final TeamRepository teamRepository;

    @Override
    public Team get(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    @Override
    public List<Team> getByOrganizationId(Long organizationId) {
        return teamRepository.findAllByOrganizationId(organizationId);
    }
}
