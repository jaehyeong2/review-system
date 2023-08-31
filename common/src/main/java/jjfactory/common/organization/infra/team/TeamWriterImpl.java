package jjfactory.common.organization.infra.team;

import jjfactory.common.organization.domain.team.Team;
import jjfactory.common.organization.domain.team.TeamWriter;
import jjfactory.common.organization.infra.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TeamWriterImpl implements TeamWriter {
    private final TeamRepository teamRepository;
    @Override
    public Team write(Team team) {
        return teamRepository.save(team);
    }
}
