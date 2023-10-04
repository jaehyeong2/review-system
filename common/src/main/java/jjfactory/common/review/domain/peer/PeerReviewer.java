package jjfactory.common.review.domain.peer;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.Feedback;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(indexes = {@Index(columnList = "userId, evaluatorId, metaId", unique = true)})
public class PeerReviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long metaId;
    private Long userId;
    private Long evaluatorId;

    private boolean isSubmitted;
    private LocalDateTime submitDt;

    @Enumerated(EnumType.STRING)
    private CreationType type;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeerReviewer that = (PeerReviewer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void submit() {
        isSubmitted = true;
        submitDt = LocalDateTime.now();
    }

    @AllArgsConstructor
    public enum CreationType {
        TEAM("팀원 자동 생성"),
        BY_EVALUATOR("평가자 신청"),
        ADMIN("관리자 등록");

        private String description;
    }

    @Builder
    public PeerReviewer(Long metaId, Long userId, Long evaluatorId, boolean isSubmitted, CreationType type) {
        this.metaId = metaId;
        this.userId = userId;
        this.evaluatorId = evaluatorId;
        this.isSubmitted = isSubmitted;
        this.type = type;
    }

    public static PeerReviewer createTeamMember(Long evaluatorId, Long userId, Long metaId){
        return PeerReviewer.builder()
                .evaluatorId(evaluatorId)
                .userId(userId)
                .type(CreationType.TEAM)
                .metaId(metaId)
                .build();
    }
}
