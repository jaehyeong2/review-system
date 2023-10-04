package jjfactory.common.user.domain;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.Feedback;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Objects;

@Where(clause = "is_valid is true")
@Getter
@Table(
        name = "users",
        indexes = @Index(columnList = "teamId")
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long teamId;
    private String name;
    private String username;
    private String email;
    private String employeeNumber;
    private boolean isValid = true;
    private LocalDateTime invalidDt;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Builder
    public User(Long teamId, String name, String username, String email, String employeeNumber) {
        this.teamId = teamId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.employeeNumber = employeeNumber;
    }

    public void delete() {
        this.isValid = false;
        this.invalidDt = LocalDateTime.now();
    }

    public void update(UserCommand.Update command) {
        if (StringUtils.hasText(command.getEmail())) this.email = command.getEmail();
        if (StringUtils.hasText(command.getUsername())) this.username = command.getUsername();
        if (!ObjectUtils.isEmpty(command.getTeamId())) this.teamId = command.getTeamId();
    }
}
