package jjfactory.common.feedback.domain;

import jakarta.persistence.*;
import jjfactory.common.feedback.domain.comment.FeedbackComment;
import jjfactory.common.feedback.domain.like.FeedbackLike;
import jjfactory.common.period.domain.review_meta.SelfReviewMeta;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(
        indexes = @Index(columnList = "receiveUserId")
)
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "feedback", cascade = CascadeType.REMOVE)
    private final List<FeedbackComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "feedback", cascade = CascadeType.REMOVE)
    private final List<FeedbackLike> likes = new ArrayList<>();
    private int likeCount;
    private Long sendUserId;
    private Long receiveUserId;

    private String content;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        COMPLIMENT, SUGGEST
    }

    @CreationTimestamp
    private LocalDateTime createDt;
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback that = (Feedback) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Builder
    public Feedback(Long sendUserId, Long receiveUserId, String content, Type type) {
        this.sendUserId = sendUserId;
        this.receiveUserId = receiveUserId;
        this.content = content;
        this.type = type;
    }

    public void update(String content, Type type) {
        if (StringUtils.hasText(content)) this.content = content;
        this.type = type;
    }

    public void increaseLikeCount(){
        likeCount++;
    }
}
