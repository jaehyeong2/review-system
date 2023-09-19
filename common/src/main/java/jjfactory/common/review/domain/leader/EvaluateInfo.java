package jjfactory.common.review.domain.leader;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class EvaluateInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long metaId;
    private long userId;
    private long evaluatorId;
    @Enumerated(EnumType.STRING)
    private Progress progress;
    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    public enum Progress {
        FIRST, FINAL
    }

    @Builder
    public EvaluateInfo(long metaId, long userId, long evaluatorId, Progress progress) {
        this.metaId = metaId;
        this.userId = userId;
        this.evaluatorId = evaluatorId;
        this.progress = progress;
    }
}
