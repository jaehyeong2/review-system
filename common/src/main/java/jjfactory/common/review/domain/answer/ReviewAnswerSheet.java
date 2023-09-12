package jjfactory.common.review.domain.answer;

import jakarta.persistence.*;
import jjfactory.common.review.domain.ReviewType;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ReviewAnswerSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long metaId;
    @Comment("평가대상. 셀프리뷰일 경우 작성자와 동일")
    private Long userId;
    @Comment("평가자")
    private Long evaluatorId;
    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_STARTED;

    @Builder
    public ReviewAnswerSheet(Long metaId, Long userId, Long evaluatorId, ReviewType reviewType, Status status) {
        this.metaId = metaId;
        this.userId = userId;
        this.evaluatorId = evaluatorId;
        this.reviewType = reviewType;
        this.status = status;
    }

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    public enum Status{
        NOT_STARTED, TEMP, COMPLETE
    }

    public static ReviewAnswerSheet ofPeer(Long userId, Long evaluatorId, Long metaId){
        return ReviewAnswerSheet.builder()
                .userId(userId)
                .evaluatorId(evaluatorId)
                .reviewType(ReviewType.PEER)
                .metaId(metaId)
                .build();
    }

    public static ReviewAnswerSheet ofLeader(Long userId, Long evaluatorId, Long metaId){
        return ReviewAnswerSheet.builder()
                .userId(userId)
                .evaluatorId(evaluatorId)
                .reviewType(ReviewType.LEADERSHIP)
                .metaId(metaId)
                .build();
    }

    public static ReviewAnswerSheet ofPerformance(Long userId, Long evaluatorId, Long metaId){
        return ReviewAnswerSheet.builder()
                .userId(userId)
                .evaluatorId(evaluatorId)
                .reviewType(ReviewType.PERFORMANCE)
                .metaId(metaId)
                .build();
    }

    public static ReviewAnswerSheet ofSelf(Long userId, Long evaluatorId, Long metaId){
        return ReviewAnswerSheet.builder()
                .userId(userId)
                .evaluatorId(evaluatorId)
                .reviewType(ReviewType.SELF)
                .metaId(metaId)
                .build();
    }
}
