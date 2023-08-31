package jjfactory.common.organization.domain.team;

import jakarta.persistence.*;
import jjfactory.common.organization.domain.Organization;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;
}
