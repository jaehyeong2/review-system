package jjfactory.common.review.domain.performance;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(indexes = {@Index(columnList = "evaluatorId, userId, metaId", unique = true)})
public class PerformanceReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long metaId;

    private Long evaluatorId;
    private Long userId;

    private boolean isSubmitted;

    private String comment;

    @Enumerated(EnumType.STRING)
    private Score score;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    public void submit() {
        isSubmitted = true;
    }

    public enum Score {
        HIGH, MEDIUM, LOW
    }

}
