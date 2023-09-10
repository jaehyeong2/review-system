package jjfactory.common.organization.domain.team;

import jakarta.persistence.*;
import jjfactory.common.organization.domain.Organization;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(
        indexes = @Index(columnList = "yearQuarterId")
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

}
