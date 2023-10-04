package jjfactory.common.feedback.domain.comment.like;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.Feedback;
import jjfactory.common.feedback.domain.comment.FeedbackComment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class FeedbackCommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private FeedbackComment feedbackComment;
    private Long userId;

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackCommentLike that = (FeedbackCommentLike) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Builder
    public FeedbackCommentLike(FeedbackComment feedbackComment, Long userId) {
        this.feedbackComment = feedbackComment;
        this.userId = userId;
    }

    public static FeedbackCommentLike create(FeedbackComment feedbackComment, Long userId){
        return FeedbackCommentLike.builder()
                .feedbackComment(feedbackComment)
                .userId(userId)
                .build();
    }
}
