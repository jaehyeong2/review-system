package jjfactory.common.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(
        name = "users",
        indexes = @Index(columnList = "teamId")
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long teamId;
    private String name;
    private String username;
    private String email;
    private String employeeNumber;

    @Builder
    public User(Long teamId, String name, String username, String email, String employeeNumber) {
        this.teamId = teamId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.employeeNumber = employeeNumber;
    }
}
