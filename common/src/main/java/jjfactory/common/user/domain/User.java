package jjfactory.common.user.domain;

import jakarta.persistence.*;

@Table(
        name = "users",
        indexes = @Index(columnList = "teamId")
)
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long teamId;
    private String name;
    private String username;
    private String email;

}
