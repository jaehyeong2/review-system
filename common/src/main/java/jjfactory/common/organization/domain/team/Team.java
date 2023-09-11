package jjfactory.common.organization.domain.team;

import jakarta.persistence.*;
import jjfactory.common.organization.domain.Organization;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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

    @Builder
    public Team(Long yearQuarterId, String name, String code, Organization organization) {
        this.yearQuarterId = yearQuarterId;
        this.name = name;
        this.code = code;
        this.organization = organization;
    }
}
