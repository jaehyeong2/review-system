package jjfactory.common.organization.domain.team;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.Feedback;
import jjfactory.common.organization.domain.Organization;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(
        indexes = @Index(columnList = "code, yearQuarterId", unique = true)
)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long yearQuarterId;
    private String name;
    private String code;
    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team that = (Team) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Builder
    public Team(Long yearQuarterId, String name, String code, Organization organization) {
        this.yearQuarterId = yearQuarterId;
        this.name = name;
        this.code = code;
        this.organization = organization;
    }
}
