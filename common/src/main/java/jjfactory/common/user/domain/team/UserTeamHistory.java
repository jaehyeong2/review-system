package jjfactory.common.user.domain.team;

import jakarta.persistence.*;
import jjfactory.common.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UserTeamHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private long teamId;

    @Builder
    public UserTeamHistory(User user, long teamId) {
        this.user = user;
        this.teamId = teamId;
    }
}
