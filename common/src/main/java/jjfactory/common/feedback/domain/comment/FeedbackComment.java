package jjfactory.common.feedback.domain.comment;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.Feedback;
import jjfactory.common.feedback.domain.comment.like.FeedbackCommentLike;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@DynamicUpdate
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class FeedbackComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Feedback feedback;
    private Long userId;
    private String content;
    int likeCount;
    @OneToMany(mappedBy = "feedbackComment", cascade = CascadeType.REMOVE)
    private final List<FeedbackCommentLike> likes = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackComment that = (FeedbackComment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Builder
    public FeedbackComment(Feedback feedback, Long userId, String content) {
        this.feedback = feedback;
        this.userId = userId;
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }

    public void increaseLikeCount() {
        likeCount++;
    }
}
